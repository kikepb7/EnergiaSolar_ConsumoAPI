package com.enriquepalmadev.energiasolar_consumoapi.compose

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.enriquepalmadev.energiasolar_consumoapi.data.RetrofitServiceFactory
import com.enriquepalmadev.energiasolar_consumoapi.data.model.ReportPOST
import com.enriquepalmadev.energiasolar_consumoapi.viewmodel.UserViewModel
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

@Composable
fun FormAddReport(
    navController: NavController,
    userViewModel: UserViewModel,
    onAddReport: (
        content: String, registrationDate: String, serialReport: String
    ) -> Unit
) {
    var content by remember { mutableStateOf("") }
    var registrationDate by remember { mutableStateOf(getCurrentDate()) }
    var serialReport by remember { mutableStateOf(generateSerialReport()) }
    var userId by remember { mutableStateOf<String?>(null) }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = content,
            onValueChange = { content = it },
            label = { Text(text = "Contenido del reporte") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = registrationDate,
            onValueChange = { registrationDate = it },
            label = { Text("Fecha de registro") },
            readOnly = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = serialReport,
            onValueChange = { serialReport = it },
            label = { Text("Número de serie del reporte") },
            readOnly = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            coroutineScope.launch {
                try {
                    userId = userViewModel.userId.value
                    val userIdLong: Long? = userId?.toLongOrNull()

                    userIdLong?.let { userId ->
                        val registrationDateParsed = parseDateStringToLocalDate(registrationDate)
                        val formattedRegistrationDate = registrationDateParsed.toString()

                        val report =
                            ReportPOST(serialReport, formattedRegistrationDate, content, userId)
                        Log.d("FormAddReport", "JSON enviado al servidor: ${report.toJsonString()}")

                        val response = RetrofitServiceFactory.makeRetrofitService()
                            .createReport(userId, report)

                        if (response.isSuccessful) {
                            onAddReport(content, registrationDate, serialReport)
                            navController.navigate("reportUser/$userId")
                        } else {
                            // Handle error
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }) {
            Text("Añadir Reporte")
        }
    }
}

fun ReportPOST.toJsonString(): String {
    val jsonObject = JSONObject().apply {
        put("serialReport", serialReport)
        put("registrationDate", registrationDate)
        put("content", content)
        put("user", user)
    }
    return jsonObject.toString()
}

private fun parseDateStringToLocalDate(dateString: String): LocalDate {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    return LocalDate.parse(dateString, formatter)
}

private fun getCurrentDate(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return sdf.format(Date())
}

private fun generateSerialReport(): String {
    val characters = ('A'..'Z')
    val randomString = (1..2).map { characters.random() }.joinToString("")
    val randomFirstNumbers = (100..999).random()
    val rendomSecondNumbers = (100..999).random()

    return "$randomString-$randomFirstNumbers-$rendomSecondNumbers"
}
