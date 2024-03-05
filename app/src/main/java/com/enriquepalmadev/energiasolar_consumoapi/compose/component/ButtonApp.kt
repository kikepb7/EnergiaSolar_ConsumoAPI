package com.enriquepalmadev.energiasolar_consumoapi.compose.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonColors
import androidx.compose.material.Colors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ButtonApp(
    text: String,
    onLogoutClicked: () -> Unit
) {
    Button(
        onClick = onLogoutClicked,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        colors = ButtonDefaults.buttonColors(Color.LightGray),
    ) {
        Text(
            text = text,
            color = Color.Black
        )
    }
}

@Composable
fun LogoutButton(
    text: String,
    navController: NavController
) {
    Button(
        onClick = { navController.navigate("home") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        colors = ButtonDefaults.buttonColors(Color.LightGray),
    ) {
        Text(
            text = text,
            color = Color.Black
        )
    }
}