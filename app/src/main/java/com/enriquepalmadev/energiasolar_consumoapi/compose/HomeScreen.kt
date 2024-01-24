package com.enriquepalmadev.energiasolar_consumoapi.compose

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enriquepalmadev.energiasolar_consumoapi.R

@Composable
fun HomeScreen(
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
        Image(painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Logo Empresarial",
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 256.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(8.dp))
        HomeScreenFooter(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 128.dp, bottom = 16.dp)
        )

    }
}

@Composable
private fun HomeScreenHeader(
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

@Composable
private fun HomeScreenFooter(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Text(
            text = "Ilumina tu futuro ",
            modifier = Modifier
                .padding(top = 256.dp),
            fontSize = 32.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = "Descubre el poder de la energía solar con nuesra guía completa de paneles solares",
            fontFamily = FontFamily.Default,
            fontSize = 16.sp
        )
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen()
}