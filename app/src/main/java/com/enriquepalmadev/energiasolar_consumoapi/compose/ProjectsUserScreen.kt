package com.enriquepalmadev.energiasolar_consumoapi.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.enriquepalmadev.energiasolar_consumoapi.R
import com.enriquepalmadev.energiasolar_consumoapi.data.model.ProjectUser
import com.enriquepalmadev.energiasolar_consumoapi.ui.theme.DarkGreyCard
import com.enriquepalmadev.energiasolar_consumoapi.ui.theme.DarkScreen

@Composable
fun ProjectsUserScreen(
    navController: NavController,
    projectsUser: List<ProjectUser>
) {
    MyProjectsList(projectsUser = projectsUser)
}

@Composable
fun MyProjectsList(projectsUser: List<ProjectUser>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(projectsUser) { panel ->
            PanelItem(panel)
        }
    }
}

@Composable
fun PanelItem(projectsUser: ProjectUser) {
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
            CardProject(
                painterResource(id = R.drawable.panel),
                "Instalación: ",
                projectsUser.name.toString()
            )
            CardProject(
                painterResource(id = R.drawable.power),
                "Dirección: ",
                projectsUser.address.toString()
            )
            CardProject(
                painterResource(id = R.drawable.price),
                "FECHA: ",
                projectsUser.generationCapacity.toString()
            )
        }
    }
}

@Composable
fun CardProject(
    icon: Painter,
    information: String,
    title: String,
) {
    val iconTint = when (information) {
        "NOMBRE DE LA INSTALACIÓN: " -> Color.Green
        "DIRECCIÓN: " -> Color.Yellow
        "FECHA: " -> Color.Red
        else -> Color.White
    }

    Card(
        modifier = Modifier,
        colors = CardDefaults.cardColors(DarkScreen),
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