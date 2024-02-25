package com.enriquepalmadev.energiasolar_consumoapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.enriquepalmadev.energiasolar_consumoapi.compose.NewScreen
import com.enriquepalmadev.energiasolar_consumoapi.compose.ProjectsUserScreen
import com.enriquepalmadev.energiasolar_consumoapi.data.RetrofitServiceFactory
import com.enriquepalmadev.energiasolar_consumoapi.data.model.LoginCredentials
import com.enriquepalmadev.energiasolar_consumoapi.ui.theme.EnergiaSolar_ConsumoAPITheme
import com.enriquepalmadev.energiasolar_consumoapi.viewmodel.ProjectViewModel
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    private val viewModel: ProjectViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val service = RetrofitServiceFactory.makeRetrofitService()

        setContent {
            val navController = rememberNavController()

            EnergiaSolar_ConsumoAPITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController, startDestination = "home") {
                        composable("home") { HomeScreen(navController = navController) }
                        composable("projectUser/{userId}") { backStackEntry ->
                            val userId = backStackEntry.arguments?.getString("userId")?.toLongOrNull()
                            userId?.let { userId ->
                                ProjectsUserScreen(
                                    navController = navController,
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
                        composable("newScreen") { NewScreen() }
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    navController: NavController
) {
    val iconPainter: Painter = painterResource(id = R.drawable.homepanels)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFFF87260),
                        Color(0xFFF8EBEB),
                    ),
                    center = Offset(1000F, 0F),
                    radius = 1200F
                )
            )
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
                .fillMaxHeight()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                HomeScreenHeader()
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = "EcoSolar Tech",
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                )
            }
            Icon(
                painter = iconPainter,
                modifier = Modifier
                    .width(256.dp)
                    .padding(top = 32.dp, end = 8.dp)
                    .align(Alignment.CenterHorizontally),
                contentDescription = "Logo principal",
                tint = Color.Black
            )
            Registration(navController = navController)
            Spacer(modifier = Modifier.padding(8.dp))
            HomeScreenFooter(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 128.dp, bottom = 16.dp)
            )
        }
    }
}

@Composable
fun HomeScreenHeader(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo Empresarial",
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Registration(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var userId by remember { mutableStateOf<String?>(null) }
    var error by remember { mutableStateOf<String?>(null) }
    var showErrorDialog by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 32.dp)
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 12.dp),
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            singleLine = true,
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 12.dp),
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") }
        )
        ElevatedButton(
            onClick = {
                coroutineScope.launch {
                    val requestBody = LoginCredentials(email, password)
                    try {
                        val response =
                            RetrofitServiceFactory.makeRetrofitService().loginUser(requestBody)
                        if (response.id != null) {
                            userId = response.id
                            navController.navigate("projectUser/${userId}")
                        } else {
                            showErrorDialog = true
                        }
                    } catch (e: Exception) {
                        error = "Error de red: ${e.message}"
                    }
                }

            },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("SIGN IN")
        }
        ElevatedButton(
            onClick = {  /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("SIGN UP")
        }
    }
    if (showErrorDialog) {
        AlertDialog(
            onDismissRequest = {
                showErrorDialog = false
            },
            title = {
                Text(text = "Error de autenticación")
            },
            text = {
                Text(text = "Las credenciales ingresadas son incorrectas. Por favor, inténtalo de nuevo.")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showErrorDialog = false
                    }
                ) {
                    Text("OK")
                }
            }
        )
    }
}

@Composable
fun HomeScreenFooter(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Ilumina tu futuro ",
            modifier = Modifier
                .padding(top = 64.dp),
            fontSize = 32.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = "Descubre el poder de la energía solar con nuesra guía completa de paneles solares",
            fontFamily = FontFamily.Default,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}