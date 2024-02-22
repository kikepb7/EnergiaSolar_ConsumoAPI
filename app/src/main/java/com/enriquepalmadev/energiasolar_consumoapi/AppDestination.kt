package com.enriquepalmadev.energiasolar_consumoapi

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.enriquepalmadev.energiasolar_consumoapi.compose.CatalogueScreen
import com.enriquepalmadev.energiasolar_consumoapi.compose.HomeScreen
import com.enriquepalmadev.energiasolar_consumoapi.compose.ProjectsUserScreen


interface AppDestination {
    val icon: ImageVector
    val route: String
    val screen: @Composable () -> Unit
}

object Catalogue : AppDestination {
    override val icon = Icons.Filled.DateRange
    override val route = "overview"
    override val screen: @Composable () -> Unit = { CatalogueScreen() }
}

object ProjectsUser : AppDestination {
    override val icon = Icons.Filled.DateRange
    override val route = "projects"
    override val screen: @Composable () -> Unit = { ProjectsUserScreen() }
}

object Profile : AppDestination {
    override val icon = Icons.Filled.Person
    override val route = "user"
    override val screen: @Composable () -> Unit = { ProfileScreen() }
}

val appTabRowScreens = listOf(Catalogue, ProjectsUser, Profile)