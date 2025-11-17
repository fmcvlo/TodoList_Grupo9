package ro.alexmamo.roomjetpackcompose.presentation.launch

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.Button
import ro.alexmamo.roomjetpackcompose.components.ClickableText
import ro.alexmamo.roomjetpackcompose.ui.theme.BackgroundGreenWhite
import ro.alexmamo.roomjetpackcompose.ui.theme.LettersAndIcons
import ro.alexmamo.roomjetpackcompose.ui.theme.MainGreen
import ro.alexmamo.roomjetpackcompose.ui.theme.PoppinsFontFamily

val SubtextColor = Color(0xFF4B4544)

@Composable
fun LaunchScreen(
    onLogInClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {},
    onForgotPasswordClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundGreenWhite)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_green),
                contentDescription = "finWise Logo",
                modifier = Modifier
                    .width(205.dp)
                    .height(185.dp)
            )
            
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod.",
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                color = SubtextColor,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(236.dp)
            )
            
            Spacer(modifier = Modifier.height(30.dp))

            Button(
                text = "Log In",
                onClick = onLogInClick,
                style = "primary",
                modifier = Modifier.width(207.dp)
            )
            
            Spacer(modifier = Modifier.height(12.dp))

            Button(
                text = "Sign Up",
                onClick = onSignUpClick,
                style = "secondary",
                modifier = Modifier.width(207.dp)
            )
            
            Spacer(modifier = Modifier.height(12.dp))

            ClickableText(
                text = "Forgot Password?",
                onClick = onForgotPasswordClick,
                color = LettersAndIcons,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LaunchScreenPreview() {
    LaunchScreen()
}

