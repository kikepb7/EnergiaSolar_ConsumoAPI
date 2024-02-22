package com.enriquepalmadev.energiasolar_consumoapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import com.enriquepalmadev.energiasolar_consumoapi.compose.HomeScreen
import com.enriquepalmadev.energiasolar_consumoapi.compose.ProjectsUserScreen
import com.enriquepalmadev.energiasolar_consumoapi.compose.ShowResult
import com.enriquepalmadev.energiasolar_consumoapi.data.RetrofitServiceFactory
import com.enriquepalmadev.energiasolar_consumoapi.ui.theme.EnergiaSolar_ConsumoAPITheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
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
//                            ShowResult("SOLAR TECH", R.drawable.logo, panels = panels)
//                            ProjectsUserScreen(projectsUser)
                        }
                    }
                }
            } catch (e: Exception) {
                println("Error fetching panel list: $e")
            }
        }
    }
}