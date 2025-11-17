package ro.alexmamo.roomjetpackcompose.presentation.login

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
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.Button
import ro.alexmamo.roomjetpackcompose.components.ClickableText
import ro.alexmamo.roomjetpackcompose.components.Input
import ro.alexmamo.roomjetpackcompose.ui.theme.BlueButton
import ro.alexmamo.roomjetpackcompose.ui.theme.DarkText
import ro.alexmamo.roomjetpackcompose.ui.theme.LettersAndIcons
import ro.alexmamo.roomjetpackcompose.ui.theme.MainGreen
import ro.alexmamo.roomjetpackcompose.ui.theme.PoppinsFontFamily
import ro.alexmamo.roomjetpackcompose.ui.theme.LightCardBackground

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit = {},
    onNavigateToSignUp: () -> Unit = {},
    onNavigateToForgotPassword: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MainGreen)

    ){

        Box(
            modifier = Modifier.weight(0.4f).fillMaxWidth(),
            contentAlignment = Alignment.Center,

        ) {
            Text(
                text = "Welcome",
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
                .padding(horizontal = 42.dp, vertical = 70.dp),

            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            var username by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

            Input(
                label = "Username",
                value = username,
                onValueChange = { username = it },
                isPassword = false,
                placeholder = "Enter your username",
                keyboardType = KeyboardType.Text
            )


            Input(
                label = "Password",
                value = password,
                onValueChange = { password = it },
                isPassword = true,
                placeholder = "Enter your password"
            )
            Spacer(modifier = Modifier.height(10.dp))
            Column(modifier = Modifier.fillMaxWidth(),verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    text = "Log In",
                    onClick = {
                        // TODO: Implementar lógica de autenticación
                        // Por ahora, navegar directamente a la pantalla autenticada
                        onLoginSuccess()
                    },
                    enabled = true,
                    style = "primary"
                )
                ClickableText(
                    text = "Forgot Password?",
                    onClick = onNavigateToForgotPassword
                )
                Button(
                    text = "Sign Up",
                    onClick = onNavigateToSignUp,
                    enabled = true,
                    style = "secondary"
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = DarkText)) {
                            append("Use ")
                        }
                        withStyle(style = SpanStyle(color = Color(0xFF0068FF))) {
                            append("fingerprint")
                        }
                        withStyle(style = SpanStyle(color = DarkText)) {
                            append(" to access")
                        }
                    },
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            // TODO: Handle fingerprint authentication
                        }
                )
                Spacer(modifier = Modifier.height(20.dp))
                // "or sign up with" text
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "or sign up with",
                        fontFamily = PoppinsFontFamily,
                        fontWeight = FontWeight.Light,
                        fontSize = 11.sp,
                        color = LettersAndIcons,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Facebook button
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .clickable {
                                    // TODO: Handle Facebook login
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.facebook),
                                contentDescription = "Facebook",
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        // Google button
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .clickable {
                                    // TODO: Handle Google login
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.google),
                                contentDescription = "Google",
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    // "Don't have an account? Sign Up" text
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(color = LettersAndIcons)) {
                                append("Don't have an account? ")
                            }
                            withStyle(style = SpanStyle(color = BlueButton)) {
                                append("Sign Up")
                            }
                        },
                        fontFamily = PoppinsFontFamily,
                        fontWeight = FontWeight.Light,
                        fontSize = 13.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(onClick = onNavigateToSignUp)
                    )
                }
            }
        }
    }
}