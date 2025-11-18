package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.withStyle
import ro.alexmamo.roomjetpackcompose.ui.theme.BlueButton
import ro.alexmamo.roomjetpackcompose.ui.theme.LettersAndIcons
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.ui.theme.PoppinsFontFamily

@Composable
fun OtherSigning(onNavigateToSignUp: () -> Unit = {},){
    Column(modifier = Modifier.fillMaxWidth(),verticalArrangement = Arrangement.spacedBy(8.dp)) {
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