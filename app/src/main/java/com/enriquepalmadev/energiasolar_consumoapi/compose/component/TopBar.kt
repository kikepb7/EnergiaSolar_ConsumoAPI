package com.enriquepalmadev.energiasolar_consumoapi.compose.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enriquepalmadev.energiasolar_consumoapi.R

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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterTopBar(
    title: String,
    solutions: String
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val iconPainter: Painter = painterResource(id = R.drawable.plug1)
    val customFont = FontFamily(Font(R.font.robotocondensed_bold))

    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        title = {
            Row {
                Text(
                    text = title,
                    fontFamily = customFont,
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(end = 8.dp)

                )
                Icon(
                    painter = iconPainter,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .width(45.dp)
                        .padding(horizontal = 4.dp),
                    contentDescription = "Logo principal",
                )
                Text(
                    text = solutions,
                    fontFamily = customFont,
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 8.dp)
                )
            }
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    /* TODO */
                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Volver hacia atrás"
                )
            }
        },
        actions = {
            IconButton(
                onClick = { /*TODO*/ })
            {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menú"
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}


@Composable
fun ScrollContent(innerPadding: PaddingValues) {
    val scrollState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        state = scrollState
    ) {
        items(100) { index ->
        }
    }
}


@Composable
@Preview(showBackground = true)
fun TopBarPreview() {
    TopBar(title = "", iconEnd = Icons.Default.Search, onIconStartClicked = { /*TODO*/ }) {
    }
}

@Composable
@Preview(showBackground = true)
fun CenterTopBarPreview() {
    CenterTopBar(title = "HOLA", solutions = "Solutions")
}