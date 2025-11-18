package ro.alexmamo.roomjetpackcompose.presentation.forgotpassword

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.activity.compose.BackHandler
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.Button
import ro.alexmamo.roomjetpackcompose.components.Input
import ro.alexmamo.roomjetpackcompose.components.OtherSigning
import ro.alexmamo.roomjetpackcompose.ui.theme.DarkText
import ro.alexmamo.roomjetpackcompose.ui.theme.LettersAndIcons
import ro.alexmamo.roomjetpackcompose.ui.theme.MainGreen
import ro.alexmamo.roomjetpackcompose.ui.theme.PoppinsFontFamily
import ro.alexmamo.roomjetpackcompose.ui.theme.LightCardBackground

val SubtextColor = Color(0xFF0E3E3E)

@Composable
fun ForgotPasswordScreen(
    onResetPasswordSuccess: () -> Unit = {},
    onNavigateToSignUp: () -> Unit = {},
    onNavigateBack: () -> Unit = {}
) {
    BackHandler {
        onNavigateBack()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MainGreen)
    ) {

        Box(
            modifier = Modifier.weight(0.4f).fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "Forgot Password",
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 30.sp,
                color = DarkText
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
                .clip(RoundedCornerShape(topStart = 70.dp, topEnd = 70.dp))
                .background(LightCardBackground)
                .padding(horizontal = 37.dp, vertical = 40.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.Start
        ) {
            // "Reset Password?" subtitle
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Reset Password?",
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = SubtextColor,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(start = 0.dp)
            )

            // Description text
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 11.sp,
                color = SubtextColor,
                textAlign = TextAlign.Start,
                lineHeight = 10.sp,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(30.dp))

            var email by remember { mutableStateOf("") }

            Input(
                label = "Enter email address",
                value = email,
                onValueChange = { email = it },
                isPassword = false,
                placeholder = "example@example.com",
                keyboardType = KeyboardType.Email
            )

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    text = "Next step",
                    onClick = {
                        // TODO: Implementar lógica de recuperación de contraseña
                        // Por ahora, navegar directamente a la pantalla autenticada
                        onResetPasswordSuccess()
                    },
                    enabled = true,
                    style = "primary"
                )

                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    text = "Sign Up",
                    onClick = onNavigateToSignUp,
                    enabled = true,
                    style = "secondary"
                )

                Spacer(modifier = Modifier.height(10.dp))

                OtherSigning(onNavigateToSignUp)
            }
        }
    }
}

