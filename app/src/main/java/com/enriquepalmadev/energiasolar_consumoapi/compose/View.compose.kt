package com.enriquepalmadev.energiasolar_consumoapi.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enriquepalmadev.energiasolar_consumoapi.R
import com.enriquepalmadev.energiasolar_consumoapi.data.model.DtoResult
import com.enriquepalmadev.energiasolar_consumoapi.data.model.Panel

/*@Composable
fun ShowResult(
    panels: List<DtoResult>,
    textHeader: String,
    imgLogo: String
) {

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ProfileHeaderOptions(optionClick = { })
            Text(text = textHeader)
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
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(panels) { panel ->
                PanelItem(panel)
            }
        }
        HomeFooter(
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}*/

@Composable
fun ShowResult(panels: List<DtoResult>) {
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
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Outlined.Menu,
                contentDescription = "Menu"
            )
        }
    }
}

@Composable
private fun ProfileHeaderLogo(
    imgLogo: String,
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


//@Composable
//fun ShowResult(panels: List<Panel>, modifier: Modifier = Modifier) {
//
//    var isCreatePanelVisible by remember { mutableStateOf(false) }
//
//    Column(
//        modifier = modifier.fillMaxSize(),
//    ) {
//        Text(
//            text = "PANELES SOLARES",
//            modifier = Modifier
//                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
//                .fillMaxWidth(),
//            style = MaterialTheme.typography.headlineLarge,
//            fontWeight = FontWeight.Bold,
//            fontSize = 32.sp,
//            color = MaterialTheme.colorScheme.primary,
//            textAlign = TextAlign.Center
//        )
//        Text(
//            text = "by Enrique Palma",
//            modifier = Modifier
//                .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 16.dp)
//                .fillMaxWidth(),
//            style = MaterialTheme.typography.headlineSmall,
//            fontWeight = FontWeight.Bold,
//            fontSize = 16.sp,
//            color = MaterialTheme.colorScheme.secondary,
//            textAlign = TextAlign.Center
//        )
//
//        Row(
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth(),
//            horizontalArrangement = Arrangement.Center
//        ) {
//            Button(
//                onClick = { isCreatePanelVisible = true },
//                colors = ButtonDefaults.buttonColors(Color.Green),
//                modifier = Modifier
//                    .height(45.dp)
//                    .width(120.dp)
//            ) {
//                Text(
//                    "Agregar",
//                    style = MaterialTheme.typography.bodySmall,
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Bold
//                )
//            }
//        }
//
//        if (isCreatePanelVisible) {
//            CreatePanel()
//        }
//
//        LazyColumn(
//            modifier = Modifier.fillMaxSize(),
//            contentPadding = PaddingValues(16.dp)
//        ) {
//            items(panels) { panel ->
//                PanelItem(panel)
//            }
//        }
//    }
//}
//
//


/*
//        Text(text = "Modelo: ${panel.model}", style = MaterialTheme.typography.bodySmall)
//        AsyncImage(model = "https://firebasestorage.googleapis.com/v0/b/paneles-solares-hibernate.appspot.com/o/EnergiaSolar-Hibernate%2FPlaca_Solar_100_Policristalino_83_49.jpg?alt=media&token=12ecf326-4693-4c2d-b873-52a04bb6bbc1", contentDescription = "Imagen")
//        Text(text = "Potencia Nominal: ${panel.nominalPower}", style = MaterialTheme.typography.bodySmall)
//        Text(text = "Precio: ${panel.price}", style = MaterialTheme.typography.bodySmall)
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 16.dp),
//            horizontalArrangement = Arrangement.SpaceBetween,
//        ) {
//            Button(
//                onClick = { /* Acción al hacer clic en Agregar */ },
//                colors = ButtonDefaults.buttonColors(OrangeEdit),
//                modifier = Modifier
//                    .height(35.dp)
//                    .width(120.dp)
//            ) {
//                Text(
//                    "Editar",
//                    style = MaterialTheme.typography.bodySmall,
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Bold
//                )
//            }
//
//            Button(
//                onClick = { /* Acción al hacer clic en Eliminar */ },
//                colors = ButtonDefaults.buttonColors(Color.Red),
//                modifier = Modifier
//                    .height(35.dp)
//                    .width(120.dp)
//            ) {
//                Text(
//                    "Eliminar",
//                    style = MaterialTheme.typography.bodySmall,
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Bold
//                )
//            }
 */
@Composable
fun PanelItem(panel: DtoResult) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//    ) {
//        LazyVerticalGrid(
//            columns = GridCells.Fixed(2),
//            contentPadding = PaddingValues(16.dp),
//            verticalArrangement = Arrangement.spacedBy(16.dp),
//            horizontalArrangement = Arrangement.spacedBy(16.dp)
//        ) {
//            items(panel.image) { image ->
//                Card(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .background(Color(0xFFEBF7FE))
//                        .wrapContentHeight(),
//                    elevation = CardDefaults.cardElevation(4.dp),
//                    shape = RoundedCornerShape(size = 12.dp)
//                ) {
//                    Column(
//                        Modifier.fillMaxWidth()
//                    ) {
//                        Text(
//                            text = "Modelo: ${panel.model}",
//                            style = MaterialTheme.typography.bodySmall
//                        )
//                        AsyncImage(
//                            model = "https://firebasestorage.googleapis.com/v0/b/paneles-solares-hibernate.appspot.com/o/EnergiaSolar-Hibernate%2FPlaca_Solar_100_Policristalino_83_49.jpg?alt=media&token=12ecf326-4693-4c2d-b873-52a04bb6bbc1",
//                            contentDescription = "Imagen"
//                        )
//                        Text(
//                            text = "Potencia Nominal: ${panel.nominalPower}",
//                            style = MaterialTheme.typography.bodySmall
//                        )
//                        Text(
//                            text = "Precio: ${panel.price}",
//                            style = MaterialTheme.typography.bodySmall
//                        )
//                    }
//                }
//            }
//        }
//    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFEBF7FE))
            .wrapContentHeight(),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(size = 12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Modelo: ${panel.model}",
                fontSize = 14.sp
            )
            // AsyncImage(model = panel.image, contentDescription = "Imagen")
            Text(
                text = "Potencia Nominal: ${panel.nominalPower}",
                fontSize = 14.sp
            )
            Text(
                text = "Precio: ${panel.price}",
                fontSize = 14.sp
            )
        }
        Divider(modifier = Modifier.padding(vertical = 8.dp))
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
}


//@Preview(showBackground = true, name = "regularView")
//@Composable
//fun Preview() {
//    val samplePanels = listOf(
//        Panel(1, "Brand1", 500.0f, 100.0f),
//        Panel(2, "Brand2", 600.0f, 120.0f),
//        Panel(3, "Brand3", 700.0f, 150.0f)
//    )
//    val modifier: Modifier
//    EnergiaSolar_ConsumoAPITheme {
//        ShowResult(panels = samplePanels, "EcoSolar Tech","https://via.placeholder.com/200")
//    }
//}