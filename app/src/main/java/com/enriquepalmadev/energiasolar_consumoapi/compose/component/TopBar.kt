package com.enriquepalmadev.energiasolar_consumoapi.compose.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBar(
    title: String,
    iconStart: ImageVector? = null,
    iconEnd: ImageVector? = null,
    onIconStartClicked: () -> Unit,
    onIconEndClicked: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)
    ) {
        if (iconStart != null) {
            Icon(
                imageVector = iconStart,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .clickable(onClick = onIconStartClicked)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = title,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        if (iconEnd != null) {
            Icon(
                imageVector = iconEnd,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clickable(onClick = onIconEndClicked)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TopBarPreview() {
    TopBar(title = "", iconEnd = Icons.Default.Search, onIconStartClicked = { /*TODO*/ }) {
    }
}