package com.enriquepalmadev.energiasolar_consumoapi.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.enriquepalmadev.energiasolar_consumoapi.R
import com.enriquepalmadev.energiasolar_consumoapi.compose.component.ButtonApp
import com.enriquepalmadev.energiasolar_consumoapi.compose.component.CenterTopBar
import com.enriquepalmadev.energiasolar_consumoapi.viewmodel.UserViewModel
import java.util.Calendar

@Composable
fun Profile(
    navController: NavController,
    userId: Long,
    viewModel: UserViewModel
) {
    val user by viewModel.user.collectAsState()

    LaunchedEffect(userId) {
        viewModel.loadUser(userId)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 128.dp)
    ) {
        CenterTopBar(
            title = stringResource(id = R.string.bussines_name),
            solutions = stringResource(id = R.string.solutions)
        )

        user?.let {
            UserCard(
                image = user!!.image,
                name = it.name,
                email = user!!.email,
                icon = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                onIconClicked = { /*TODO*/ })
        }

        Spacer(modifier = Modifier.height(8.dp))

        SmallCard(
            iconStart = Icons.Outlined.AccountBox,
            text = "Notificaciones",
            iconEnd = Icons.AutoMirrored.Filled.KeyboardArrowRight
        )

        SmallCard(
            iconStart = Icons.Default.Star,
            text = "Puntua la App",
            iconEnd = Icons.AutoMirrored.Filled.KeyboardArrowRight
        )

        Spacer(modifier = Modifier.weight(1f))

        Column {
            ButtonApp(
                text = "Log out"
            ) {
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "© ${Calendar.getInstance().get(Calendar.YEAR)} Solar Tech",
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Composable
fun UserCard(
    image: String,
    name: String,
    email: String,
    icon: ImageVector,
    onIconClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(image)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ic_launcher_background),
            contentDescription = stringResource(R.string.avatar_user),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .padding(end = 16.dp)
                .clip(CircleShape)
        )

        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = name)
            Text(
                text = email,
                color = Color.Gray.copy(alpha = 0.5f)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .padding(start = 8.dp)
                .clickable(onClick = onIconClicked)
        )
    }
}

@Composable
fun SmallCard(
    iconStart: ImageVector,
    text: String,
    iconEnd: ImageVector,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Icon(
                imageVector = iconStart,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = text,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(start = 16.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = iconEnd,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
            )
        }
    }
}