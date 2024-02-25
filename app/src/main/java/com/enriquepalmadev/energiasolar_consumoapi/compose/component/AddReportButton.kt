package com.enriquepalmadev.energiasolar_consumoapi.compose.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AddReportButton(
    navController: NavController,
    userId: Long,
) {
    FloatingActionButton(
        onClick = { navController.navigate("addReportForm/$userId")},
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(text = "+")
    }
}
