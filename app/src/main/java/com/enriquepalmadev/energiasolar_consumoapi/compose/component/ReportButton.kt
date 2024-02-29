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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.enriquepalmadev.energiasolar_consumoapi.viewmodel.UserViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

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
    userViewModel: UserViewModel,
    reportId: Long,
) {
    var userId by remember { mutableStateOf<String?>(null) }
    val coroutineScope = rememberCoroutineScope()


    FloatingActionButton(
        onClick = {
            coroutineScope.launch {
                userId = userViewModel.userId.value
                userId?.let {
                    navController.navigate("removeReport/$reportId")
                }
            }
        },
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
