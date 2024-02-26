package com.enriquepalmadev.energiasolar_consumoapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.enriquepalmadev.energiasolar_consumoapi.compose.FormAddReport
import com.enriquepalmadev.energiasolar_consumoapi.compose.HomeScreen
import com.enriquepalmadev.energiasolar_consumoapi.compose.Profile
import com.enriquepalmadev.energiasolar_consumoapi.compose.ProjectsUserScreen
import com.enriquepalmadev.energiasolar_consumoapi.compose.ReportsUserScreen
import com.enriquepalmadev.energiasolar_consumoapi.ui.theme.EnergiaSolar_ConsumoAPITheme
import com.enriquepalmadev.energiasolar_consumoapi.viewmodel.ProjectViewModel
import com.enriquepalmadev.energiasolar_consumoapi.viewmodel.ReportViewModel
import com.enriquepalmadev.energiasolar_consumoapi.viewmodel.UserViewModel


class MainActivity : ComponentActivity() {
    private val viewModel: ProjectViewModel by viewModels()
    private val userViewModel: UserViewModel by viewModels()
    private val reportViewModel: ReportViewModel by viewModels()
    private var authenticatedUserId: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            EnergiaSolar_ConsumoAPITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController, startDestination = "home") {
                        composable("home") {
                            HomeScreen(
                                navController = navController,
                                userViewModel = userViewModel
                            )
                        }

                        composable("projectUser/{userId}") { backStackEntry ->
                            val userId =
                                backStackEntry.arguments?.getString("userId")?.toLongOrNull()
                            userId?.let {
                                authenticatedUserId = userId
                                ProjectsUserScreen(
                                    navController = navController,
                                    userViewModel = userViewModel,
                                    userId = userId,
                                    viewModel = viewModel
                                )
                            } ?: kotlin.run {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(text = "No se ha proporcionado un ID de usuario válido.")
                                }
                            }
                        }

                        composable("profile/{userId}") { navBackStackEntry ->
                            val userId =
                                navBackStackEntry.arguments?.getString("userId")?.toLongOrNull()
                            userId?.let {
                                Profile(
                                    navController = navController,
                                    userId = userId,
                                    viewModel = userViewModel
                                )
                            }
                        }

                        composable("reportUser/{userId}") { reportBackStackEntry ->
                            val userId =
                                reportBackStackEntry.arguments?.getString("userId")?.toLongOrNull()
                            userId?.let {
                                ReportsUserScreen(
                                    navController = navController,
                                    userViewModel = userViewModel,
                                    userId = userId,
                                    viewModel = reportViewModel
                                )
                            }
                        }

                        composable("addReportForm/{userId}") { addReportBackStackEntry ->
                            val userId = addReportBackStackEntry.arguments?.getString("userId")
                                ?.toLongOrNull()
                            userId?.let {
                                FormAddReport(
                                    navController = navController,
                                    userViewModel = userViewModel,
                                    onAddReport = { _, _, _ -> }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}