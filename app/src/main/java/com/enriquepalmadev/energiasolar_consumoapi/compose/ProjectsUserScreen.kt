package com.enriquepalmadev.energiasolar_consumoapi.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.enriquepalmadev.energiasolar_consumoapi.R
import com.enriquepalmadev.energiasolar_consumoapi.compose.component.BottomMenu
import com.enriquepalmadev.energiasolar_consumoapi.compose.component.TopBar
import com.enriquepalmadev.energiasolar_consumoapi.data.model.Project
import com.enriquepalmadev.energiasolar_consumoapi.ui.theme.ButtonColor
import com.enriquepalmadev.energiasolar_consumoapi.viewmodel.ProjectViewModel
import com.enriquepalmadev.energiasolar_consumoapi.viewmodel.UserViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProjectsUserScreen(
    navController: NavController,
    userViewModel: UserViewModel,
    userId: Long,
    viewModel: ProjectViewModel
) {
    val projects by viewModel.projects.collectAsState()

    LaunchedEffect(userId) {
        viewModel.loadProjects(userId)
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
                Spacer(modifier = Modifier.height(16.dp))
                MyProjectsList(projects, navController)
            }

        },
        bottomBar = {
            BottomMenu(navController = navController, userViewModel = userViewModel)
        }
    )
}


@Composable
fun MyProjectsList(projects: List<Project>, navController: NavController) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(projects) { project ->
            ProjectItem(project, navController)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ProjectItem(
    project: Project,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(project.image)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentDescription = stringResource(R.string.project_image_description),
                placeholder = painterResource(R.drawable.ic_launcher_background)
            )



            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = project.name,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = project.address,
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = project.generationCapacity.toString() + " W",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    navController.navigate("/proyecto/${project.id}")
                },
                modifier = Modifier.align(Alignment.End),
                colors = ButtonDefaults.buttonColors(ButtonColor)
            ) {
                Text(
                    text = stringResource(id = R.string.details),
                    color = Color.Black
                )
            }
        }
    }
}