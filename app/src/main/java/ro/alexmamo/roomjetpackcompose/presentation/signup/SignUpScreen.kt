package ro.alexmamo.roomjetpackcompose.presentation.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.activity.compose.BackHandler
import ro.alexmamo.roomjetpackcompose.components.Button
import ro.alexmamo.roomjetpackcompose.components.ClickableText
import ro.alexmamo.roomjetpackcompose.components.Input
import ro.alexmamo.roomjetpackcompose.ui.theme.BlackText
import ro.alexmamo.roomjetpackcompose.ui.theme.BlueButton
import ro.alexmamo.roomjetpackcompose.ui.theme.DarkText
import ro.alexmamo.roomjetpackcompose.ui.theme.LettersAndIcons
import ro.alexmamo.roomjetpackcompose.ui.theme.LightCardBackground
import ro.alexmamo.roomjetpackcompose.ui.theme.MainGreen
import ro.alexmamo.roomjetpackcompose.ui.theme.PoppinsFontFamily

val SubtextColor = Color(0xFF4B4544)

@Composable
fun SignUpScreen(
    onSignUpSuccess: () -> Unit = {},
    onNavigateToLogin: () -> Unit = {},
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
            modifier = Modifier.weight(0.3f).fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "Create Account",
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
                .padding(horizontal = 42.dp, vertical = 40.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var fullName by remember { mutableStateOf("") }
            var email by remember { mutableStateOf("") }
            var mobileNumber by remember { mutableStateOf("") }
            var dateOfBirth by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var confirmPassword by remember { mutableStateOf("") }

            Input(
                label = "Full name",
                value = fullName,
                onValueChange = { fullName = it },
                isPassword = false,
                placeholder = "Enter your full name",
                keyboardType = KeyboardType.Text
            )

            Input(
                label = "Email",
                value = email,
                onValueChange = { email = it },
                isPassword = false,
                placeholder = "example@example.com",
                keyboardType = KeyboardType.Email
            )

            Input(
                label = "Mobile Number",
                value = mobileNumber,
                onValueChange = { mobileNumber = it },
                isPassword = false,
                placeholder = "+ 123 456 789",
                keyboardType = KeyboardType.Phone
            )

            Input(
                label = "Date of birth",
                value = dateOfBirth,
                onValueChange = { dateOfBirth = it },
                isPassword = false,
                placeholder = "DD / MM / YYYY",
                keyboardType = KeyboardType.Text
            )

            Input(
                label = "Password",
                value = password,
                onValueChange = { password = it },
                isPassword = true,
                placeholder = "Enter your password"
            )

            Input(
                label = "Confirm Password",
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                isPassword = true,
                placeholder = "Confirm your password"
            )



            Column(
                modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(0.dp)
            ) {
                // Terms of Use and Privacy Policy text
                Text(
                    text = "By continuing, you agree to",
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    color = SubtextColor,
                    lineHeight = 14.sp
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = SubtextColor, fontWeight = FontWeight.SemiBold)) {
                            append("Terms of Use")
                        }
                        withStyle(style = SpanStyle(color = SubtextColor)) {
                            append(" and ")
                        }
                        withStyle(style = SpanStyle(color = SubtextColor, fontWeight = FontWeight.SemiBold)) {
                            append("Privacy Policy.")
                        }
                    },
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    color = BlackText,
                    lineHeight = 14.sp
                )

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    text = "Sign Up",
                    onClick = {
                        // TODO: Implementar lógica de registro
                        // Por ahora, navegar directamente a la pantalla autenticada
                        onSignUpSuccess()
                    },
                    enabled = true,
                    style = "primary"
                )

                Spacer(modifier = Modifier.height(10.dp))

                // "Already have an account? Log In" text
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = DarkText)) {
                            append("Already have an account?  ")
                        }
                        withStyle(style = SpanStyle(color = BlueButton)) {
                            append("Log In")
                        }
                    },
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(onClick = onNavigateToLogin)
                )
            }
        }
    }
}


