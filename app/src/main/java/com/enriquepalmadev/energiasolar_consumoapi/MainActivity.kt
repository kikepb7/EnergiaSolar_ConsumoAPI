package com.enriquepalmadev.energiasolar_consumoapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.enriquepalmadev.energiasolar_consumoapi.compose.HomeScreen
import com.enriquepalmadev.energiasolar_consumoapi.ui.AppTabRow
import com.enriquepalmadev.energiasolar_consumoapi.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val service = RetrofitServiceFactory.makeRetrofitService()

        lifecycleScope.launch {
            try {
                // DTO paneles solares
                val panels = service.dtoList()

                // Proyectos que tiene un usuario
                val projectsUser = service.projectsUserList()


                setContent {
                    EnergiaSolar_ConsumoAPITheme {
                        // A surface container using the 'background' color from the theme
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            HomeScreen()
//                            CatalogueScreen("SOLAR TECH", R.drawable.logo, panels = panels)
//                            ProjectsUserScreen(projectsUser)
                        }
                    }
                }
            } catch (e: Exception) {
                println("Error fetching panel list: $e")
            }
        }
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SolarApp()
        }
    }
}

@Composable
fun SolarApp() {
    AppTheme {
        var currentScreen: HomeDestination by remember { mutableStateOf(HomeScreen()) }
        Scaffold(
            topBar = {
                AppTabRow(
                    allScreens = appTabRowsScreens,
                    onTableSelected = { screen -> currentScreen = screen },
                    currentScreen = currentScreen
                )
            }
        ) { innerPadding ->
            Box(Modifier.padding(innerPadding)) {
                currentScreen.screen()
            }
        }
    }
}a