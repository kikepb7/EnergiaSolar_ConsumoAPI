package com.enriquepalmadev.energiasolar_consumoapi.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enriquepalmadev.energiasolar_consumoapi.R
import com.enriquepalmadev.energiasolar_consumoapi.data.model.Panel
import com.enriquepalmadev.energiasolar_consumoapi.ui.theme.EnergiaSolar_ConsumoAPITheme
import com.enriquepalmadev.energiasolar_consumoapi.ui.theme.OrangeEdit

@Composable
fun ShowResult(panels: List<Panel>, modifier: Modifier = Modifier) {

    var isCreatePanelVisible by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        Text(
            text = "PANELES SOLARES",
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )
        Text(
            text = "by Enrique Palma",
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 16.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.secondary,
            textAlign = TextAlign.Center
        )

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { isCreatePanelVisible = true },
                colors = ButtonDefaults.buttonColors(Color.Green),
                modifier = Modifier
                    .height(45.dp)
                    .width(120.dp)
            ) {
                Text(
                    "Agregar",
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        if (isCreatePanelVisible) {
            CreatePanel()
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(panels) { panel ->
                PanelItem(panel)
            }
        }
    }
}


@Composable
fun PanelItem(panel: Panel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "ID: ${panel.id}", style = MaterialTheme.typography.bodySmall)
        Text(text = "Marca: ${panel.brand}", style = MaterialTheme.typography.bodySmall)
        Text(text = "Precio: ${panel.price} €", style = MaterialTheme.typography.bodySmall)
        Text(text = "Potencia: ${panel.nominalPower} W", style = MaterialTheme.typography.bodySmall)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Button(
                onClick = { /* Acción al hacer clic en Agregar */ },
                colors = ButtonDefaults.buttonColors(OrangeEdit),
                modifier = Modifier
                    .height(35.dp)
                    .width(120.dp)
            ) {
                Text(
                    "Editar",
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Button(
                onClick = { /* Acción al hacer clic en Eliminar */ },
                colors = ButtonDefaults.buttonColors(Color.Red),
                modifier = Modifier
                    .height(35.dp)
                    .width(120.dp)
            ) {
                Text(
                    "Eliminar",
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Divider(modifier = Modifier.padding(vertical = 8.dp))
    }
}

@Preview(showBackground = true, name = "regularView", fontScale = 2f)
@Composable
fun Preview() {
    val samplePanels = listOf(
        Panel(1, "Brand1", 500.0f, 100.0f),
        Panel(2, "Brand2", 600.0f, 120.0f),
        Panel(3, "Brand3", 700.0f, 150.0f)
    )
    EnergiaSolar_ConsumoAPITheme {
        ShowResult(panels = samplePanels)
    }
}