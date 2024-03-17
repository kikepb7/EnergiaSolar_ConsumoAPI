package com.enriquepalmadev.energiasolar_consumoapi.compose.component

import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.enriquepalmadev.energiasolar_consumoapi.viewmodel.UserViewModel
import kotlinx.coroutines.launch


@Composable
fun BottomMenu(navController: NavController, userViewModel: UserViewModel) {
    var userId by remember { mutableStateOf<String?>(null) }
    val coroutineScope = rememberCoroutineScope()

    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.White,
        elevation = 8.dp,
        modifier = Modifier.height(64.dp)
    ) {
        BottomNavigationItem(
            selected = false,
            onClick = {
                coroutineScope.launch {
                    userId = userViewModel.userId.value
                    userId?.let {
                        navController.navigate("paneles/mostrar") {
                            launchSingleTop = true
                        }
                    }
                }
            },
            icon = { Icon(Icons.Default.Home, contentDescription = "Paneles") },
            label = { Text("Paneles", fontSize = 12.sp) }
        )
        BottomNavigationItem(
            selected = false,
            onClick = {
                coroutineScope.launch {
                    userId = userViewModel.userId.value
                    userId?.let {
                        navController.navigate("projectUser/$userId")
                    }
                }
            },
            icon = { Icon(Icons.Default.Info, contentDescription = "Proyectos") },
            label = { Text("Proyectos", fontSize = 12.sp) }
        )
        BottomNavigationItem(
            selected = false,
            onClick = {
                coroutineScope.launch {
                    userId = userViewModel.userId.value
                    userId?.let {
                        navController.navigate("reportUser/$userId")
                    }
                }
            },
            icon = { Icon(Icons.Default.Build, contentDescription = "Reportes") },
            label = { Text("Reportes", fontSize = 12.sp) }
        )
        BottomNavigationItem(
            selected = false,
            onClick = {
                coroutineScope.launch {
                    userId = userViewModel.userId.value
                    userId?.let {
                        navController.navigate("profile/$userId")
                    }
                }
            },
            icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
            label = { Text("Perfil", fontSize = 12.sp) }
        )
    }
}