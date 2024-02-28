package com.enriquepalmadev.energiasolar_consumoapi.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.enriquepalmadev.energiasolar_consumoapi.data.model.Project
import com.enriquepalmadev.energiasolar_consumoapi.viewmodel.ProjectViewModel
import com.enriquepalmadev.energiasolar_consumoapi.viewmodel.UserViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProjectDescriptionScreen(
    navController: NavController,
    userViewModel: UserViewModel,
    projectId: Long,
    viewModel: ProjectViewModel
) {
    val projectList by viewModel.projects.collectAsState()
    val project: Project? = projectList.firstOrNull()

    LaunchedEffect(projectId) {
        viewModel.loadSingleProject(projectId)
    }

    Scaffold(
        topBar = {
            TopBar(
                title = stringResource(R.string.bussines_name),
                onIconStartClicked = { /* TODO */ }
            ) {}
        },
        content = {
            Column(
                modifier = Modifier.padding(top = 32.dp, bottom = 48.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                MyProject(project)
            }
        },
        bottomBar = {
            BottomMenu(navController = navController, userViewModel = userViewModel)
        }
    )
}

@Composable
fun MyProject(project: Project?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        if (project != null) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(project.image)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_launcher_background),
                contentDescription = stringResource(R.string.project_image_description),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = project.name,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = project.address,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.LightGray
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = project.description,
                fontSize = 18.sp,
            )
        }
    }
}
