package com.enriquepalmadev.energiasolar_consumoapi.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.enriquepalmadev.energiasolar_consumoapi.data.model.Project
import com.enriquepalmadev.energiasolar_consumoapi.ui.theme.DarkGreyCard
import com.enriquepalmadev.energiasolar_consumoapi.ui.theme.DarkScreen
import com.enriquepalmadev.energiasolar_consumoapi.viewmodel.ProjectViewModel

@Composable
fun ProjectsUserScreen(
    navController: NavController,
    userId: Long,
    viewModel: ProjectViewModel
) {
    val projects by viewModel.projects.collectAsState()

    LaunchedEffect(userId) {
        viewModel.loadProjects(userId)
    }

    MyProjectsList(projects)
}

@Composable
fun MyProjectsList(projects: List<Project>) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(projects) { project ->
            ProjectItem(project)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ProjectItem(project: Project) {
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
                project.name
            )
            CardProject(
                painterResource(id = R.drawable.power),
                "Dirección: ",
                project.address
            )
            CardProject(
                painterResource(id = R.drawable.price),
                "Potencia total: ",
                project.generationCapacity.toString() + " W"
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