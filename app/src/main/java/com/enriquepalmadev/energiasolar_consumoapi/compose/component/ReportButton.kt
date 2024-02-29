package com.enriquepalmadev.energiasolar_consumoapi.compose.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
            .padding(8.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Botón de añadir"
        )
    }
}

@Composable
fun UpdateReportButton(
    navController: NavController,
    userId: Long,
) {
    FloatingActionButton(
        onClick = { navController.navigate("updateReportForm/$userId")},
        modifier = Modifier
            .size(48.dp),
        containerColor = Color.Yellow
    ) {
        Icon(
            imageVector = Icons.Default.Edit,
            contentDescription = "Botón de editar",
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun RemoveReportButton(
    navController: NavController,
    userId: Long,
) {
    FloatingActionButton(
        onClick = { navController.navigate("removeReportForm/$userId")},
        modifier = Modifier
            .size(48.dp),
        containerColor = Color.Red
    ) {
        Icon(
            imageVector = Icons.Default.Clear,
            contentDescription = "Botón de eliminar",
            modifier = Modifier.size(24.dp)
        )
    }
}
