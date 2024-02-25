package com.enriquepalmadev.energiasolar_consumoapi.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.enriquepalmadev.energiasolar_consumoapi.compose.component.AddReportButton
import com.enriquepalmadev.energiasolar_consumoapi.compose.component.BottomMenu
import com.enriquepalmadev.energiasolar_consumoapi.compose.component.TopBar
import com.enriquepalmadev.energiasolar_consumoapi.data.model.Report
import com.enriquepalmadev.energiasolar_consumoapi.viewmodel.ReportViewModel
import com.enriquepalmadev.energiasolar_consumoapi.viewmodel.UserViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ReportsUserScreen(
    navController: NavController,
    userViewModel: UserViewModel,
    userId: Long,
    viewModel: ReportViewModel
) {
    val reports by viewModel.reports.collectAsState()

    LaunchedEffect(userId) {
        viewModel.loadReports(userId)
    }

    Scaffold(
        topBar = {
            TopBar(
                title = "Reportes",
                iconStart = Icons.AutoMirrored.Filled.ArrowBack,
                onIconStartClicked = { /*TODO*/ }) {
            }
        },
        content = {
            Column(
                modifier = Modifier.padding(top = 32.dp, bottom = 48.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                MyReportsList(reports)
            }
        },
        bottomBar = {
            BottomMenu(navController = navController, userViewModel = userViewModel)
        },
        floatingActionButton = {
            AddReportButton(navController = navController, userId = userId)
        }
    )
}

@Composable
fun MyReportsList(reports: List<Report>) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(reports) { report ->
            ReportItem(report)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ReportItem(report: Report) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = report.content)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = report.registrationDate.toString())
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = report.serialReport)
        }
    }
}