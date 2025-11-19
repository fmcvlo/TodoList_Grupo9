package ro.alexmamo.roomjetpackcompose.presentation.profile

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.ui.theme.*

@Composable
fun ProfileScreen() {
    val scrollState = rememberScrollState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MainGreen)
        ) {
            TopAppBar()
            Spacer(modifier = Modifier.height(90.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                    .background(Color.White)
                    .padding(top = 80.dp, start = 24.dp, end = 24.dp, bottom = 24.dp)
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "John Smith",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = LettersAndIcons
                )
                Row {
                    Text(
                        text = "ID: ",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = LettersAndIcons
                    )
                    Text(
                        text = "25030024",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                ProfileMenuItem(text = "Edit Profile")
                ProfileMenuItem(text = "Security")
                ProfileMenuItem(text = "Setting")
                ProfileMenuItem(text = "Help")
                ProfileMenuItem(text = "Logout")
            }
        }
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile Picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 94.dp)
                .size(120.dp)
                .clip(CircleShape)
        )
    }
}

@Composable
fun TopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.White
        )
        Text(
            text = "Profile",
            color = LettersAndIcons,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Notifications",
            tint = Color.White
        )
    }
}

@Composable
fun ProfileMenuItem(text: String) {
    @DrawableRes val iconRes: Int
    val backgroundColor: Color
    val iconTint: Color

    when (text) {
        "Edit Profile" -> {
            iconRes = R.drawable.profile
            backgroundColor = LightBlueButton
            iconTint = Color.White
        }
        "Security" -> {
            iconRes = R.drawable.security
            backgroundColor = BlueButton
            iconTint = Color.White
        }
        "Setting" -> {
            iconRes = R.drawable.settings
            backgroundColor = OceanBlue
            iconTint = Color.White
        }
        "Help" -> {
            iconRes = R.drawable.help
            backgroundColor = LightBlueButton
            iconTint = Color.White
        }
        "Logout" -> {
            iconRes = R.drawable.logout
            backgroundColor = BlueButton
            iconTint = Color.White
        }
        else -> {
            iconRes = R.drawable.more
            backgroundColor = ProfileIconBgLightBlue
            iconTint = Color.White
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(backgroundColor),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = iconTint
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            fontSize = 15.sp,
            color = LettersAndIcons,
            fontWeight = FontWeight.Medium
        )
    }
}
