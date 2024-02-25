package com.enriquepalmadev.energiasolar_consumoapi.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.enriquepalmadev.energiasolar_consumoapi.R
import com.enriquepalmadev.energiasolar_consumoapi.ui.theme.DarkGreyCard
import com.enriquepalmadev.energiasolar_consumoapi.ui.theme.DarkScreen

/*
@Composable
fun ShowResult(
    navController: NavController,
    textHeader: String,
    imgLogo: Int,
    panels: List<DtoResult>
) {
    Column(
        modifier = Modifier
            .background(color = DarkScreen)
    ) {
        MyHeader(textHeader = textHeader, imgLogo = imgLogo)
        MyCarousel()
        Spacer(modifier = Modifier.width(16.dp))
        MyItemList(panels = panels)
    }
}

@Composable
fun MyHeader(textHeader: String, imgLogo: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ProfileHeaderOptions(optionClick = {})
        Text(
            text = textHeader,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        ProfileHeaderLogo(imgLogo = imgLogo)
    }
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
fun MyItemList(panels: List<DtoResult>) {
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
private fun ProfileHeaderOptions(
    optionClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        IconButton(onClick = { *//* TODO *//* }) {
            Icon(
                imageVector = Icons.Outlined.Menu,
                contentDescription = "Menu",
                tint = Color.White
            )
        }
    }
}

@Composable
private fun ProfileHeaderLogo(
    imgLogo: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo de la App",
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
        )
    }
}

@Composable
private fun PanelCard() {
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyChipInfo(
    icon: Painter,
    information: String,
    title: String,
) {
    val iconTint = when (information) {
        "MODELO: " -> Color.Green
        "POTENCIA: " -> Color.Yellow
        "PRECIO: " -> Color.Red
        else -> Color.White
    }

    Chip(
        onClick = { *//*TODO*//* },
        colors = ChipDefaults.chipColors(backgroundColor = DarkScreen),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = icon,
                modifier = Modifier
                    .size(20.dp)
                    .padding(end = 8.dp),
                contentDescription = "Icono",
                tint = iconTint
            )
            Text(
                text = information,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp
            )
            Text(
                text = title,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp
            )
        }
    }
}

@Composable
fun PanelItem(panel: DtoResult) {
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = "https://firebasestorage.googleapis.com/v0/b/paneles-solares-hibernate.appspot.com/o/EnergiaSolar-Hibernate%2FPlaca_Solar_100_Policristalino_83_49.jpg?alt=media&token=12ecf326-4693-4c2d-b873-52a04bb6bbc1",
                contentDescription = "Imagen",
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )
            MyChipInfo(
                painterResource(id = R.drawable.panel),
                "MODELO: ",
                panel.model.toString()
            )
            MyChipInfo(
                painterResource(id = R.drawable.power),
                "POTENCIA: ",
                panel.nominalPower.toString() + " W"
            )
            MyChipInfo(
                painterResource(id = R.drawable.price),
                "PRECIO: ",
                panel.price.toString() + " €"
            )
        }
    }

    @Composable
    fun HomeFooter(
        modifier: Modifier = Modifier
    ) {
        BottomNavigation(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = Color.White
        ) {
            BottomNavigationItem(
                selected = true,
                onClick = { *//*TODO*//* },
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.KeyboardArrowUp,
                        contentDescription = "Página principal",
                        tint = Color.Green
                    )
                }
            )
            BottomNavigationItem(
                selected = false,
                onClick = { *//*TODO*//* },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "Lista de la compra",
                        tint = Color.Black
                    )
                }
            )
            BottomNavigationItem(
                selected = false,
                onClick = { *//*TODO*//* },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Perfil de usuario",
                        tint = Color.Black
                    )
                }
            )
        }
    }
}*/


/*
@Composable
fun ShowResult(
    textHeader: String,
    imgLogo: Int,
    panels: List<DtoResult>
) {
    Column(
        modifier = Modifier
            .background(color = DarkScreen)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ProfileHeaderOptions(optionClick = { })
            Text(
                text = textHeader,
                color = Color.White,
                fontWeight = FontWeight.Bold
                )
            ProfileHeaderLogo(imgLogo = imgLogo)
        }
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
        Spacer(
            modifier = Modifier
                .width(16.dp)
        )
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
}


@Composable
private fun ProfileHeaderOptions(
    optionClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        IconButton(onClick = { */
/*TODO*//*
 }) {
            Icon(
                imageVector = Icons.Outlined.Menu,
                contentDescription = "Menu",
                tint = Color.White
            )
        }
    }
}

@Composable
private fun ProfileHeaderLogo(
    imgLogo: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo de la App",
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
        )
    }
}

@Composable
private fun PanelCard() {
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
fun PanelItem(panel: DtoResult) {
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
                model = "https://firebasestorage.googleapis.com/v0/b/paneles-solares-hibernate.appspot.com/o/EnergiaSolar-Hibernate%2FPlaca_Solar_100_Policristalino_83_49.jpg?alt=media&token=12ecf326-4693-4c2d-b873-52a04bb6bbc1",
                contentDescription = "Imagen",
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )

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
                        text = "POTENCIA: ${panel.nominalPower} W",
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


    @Composable
    fun HomeFooter(
        modifier: Modifier = Modifier
    ) {
        BottomNavigation(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = Color.White,
        ) {
            BottomNavigationItem(
                selected = true,
                onClick = {},
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.KeyboardArrowUp,
                        contentDescription = "Página principal",
                        tint = Color.Green
                    )
                },
            )
            BottomNavigationItem(
                selected = false,
                onClick = {},
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "Lista de la compra",
                        tint = Color.Black
                    )
                },
            )
            BottomNavigationItem(
                selected = false,
                onClick = {},
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Perfil de usuario",
                        tint = Color.Black
                    )
                }
            )
        }
    }
}*/
