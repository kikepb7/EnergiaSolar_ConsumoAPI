package com.enriquepalmadev.energiasolar_consumoapi.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.enriquepalmadev.energiasolar_consumoapi.R
import com.enriquepalmadev.energiasolar_consumoapi.compose.component.BottomMenu
import com.enriquepalmadev.energiasolar_consumoapi.compose.component.TopBar
import com.enriquepalmadev.energiasolar_consumoapi.data.model.Panel
import com.enriquepalmadev.energiasolar_consumoapi.ui.theme.DarkGreyCard
import com.enriquepalmadev.energiasolar_consumoapi.ui.theme.DarkScreen
import com.enriquepalmadev.energiasolar_consumoapi.viewmodel.PanelViewModel
import com.enriquepalmadev.energiasolar_consumoapi.viewmodel.UserViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PanelsScreen(
    navController: NavController,
    userViewModel: UserViewModel,
    viewModel: PanelViewModel,
) {
    val panels by viewModel.panels.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadPanels()
    }


    Scaffold(
        topBar = {
            TopBar(
                title = stringResource(R.string.bussines_name),
                onIconStartClicked = { /*TODO*/ }) {
            }
        },
        content = {
            Column(
                modifier = Modifier.padding(top = 32.dp, bottom = 48.dp)
            ) {
                MyCarousel()
                Spacer(modifier = Modifier.height(16.dp))
                MyItemList(panels)

            }

        },
        bottomBar = {
            BottomMenu(navController = navController, userViewModel = userViewModel)
        }
    )
}

@Composable
fun MyCarousel() {
    LazyRow {
        items(5) { index ->
            if (index == 0) {
                Spacer(
                    modifier = Modifier
                        .width(16.dp)
                )
                PanelCard()
            } else {
                PanelCard()
            }
        }
    }
}

@Composable
fun PanelCard() {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .width(256.dp)
            .height(128.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Imagen del panel",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}


@Composable
fun MyItemList(panels: List<Panel>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(panels) { panel ->
            PanelItem(panel)
        }
    }
}

@Composable
fun PanelItem(panel: Panel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(DarkGreyCard),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(size = 12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(panel.image)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentDescription = stringResource(R.string.panel_image_description),
                placeholder = painterResource(R.drawable.ic_launcher_background)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier
                    .height(16.dp)
                    .width(128.dp)
                    .padding(bottom = 4.dp),
                colors = CardDefaults.cardColors(DarkScreen),
                elevation = CardDefaults.cardElevation(4.dp),
                shape = RoundedCornerShape(size = 16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Create,
                        contentDescription = "Modelo",
                        tint = Color.White
                    )

                    Text(
                        text = "MODELO: ${panel.model}",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp
                    )
                }
            }

            Card(
                modifier = Modifier
                    .height(16.dp)
                    .width(128.dp)
                    .padding(bottom = 4.dp),
                colors = CardDefaults.cardColors(DarkScreen),
                elevation = CardDefaults.cardElevation(4.dp),
                shape = RoundedCornerShape(size = 16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Create,
                        contentDescription = "Modelo",
                        tint = Color.White
                    )

                    Text(
                        text = "EFICIENCIA: ${panel.efficiency}",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp
                    )
                }
            }

            Card(
                modifier = Modifier
                    .height(16.dp)
                    .width(128.dp)
                    .padding(bottom = 4.dp),
                colors = CardDefaults.cardColors(DarkScreen),
                elevation = CardDefaults.cardElevation(4.dp),
                shape = RoundedCornerShape(size = 16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Create,
                        contentDescription = "Modelo",
                        tint = Color.White
                    )

                    Text(
                        text = "PRECIO: ${panel.price} €",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}