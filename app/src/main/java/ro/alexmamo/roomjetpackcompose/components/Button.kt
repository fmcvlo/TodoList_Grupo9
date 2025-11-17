package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.ui.theme.LettersAndIcons
import androidx.compose.ui.graphics.Color
import ro.alexmamo.roomjetpackcompose.ui.theme.LightGreen
import ro.alexmamo.roomjetpackcompose.ui.theme.MainGreen
import ro.alexmamo.roomjetpackcompose.ui.theme.PoppinsFontFamily

@Composable
fun Button(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    style: String = "primary"
) {
    val backgroundColor = when (style.lowercase()) {
        "primary" -> MainGreen
        "secondary" -> LightGreen
        else -> MainGreen // Default to primary if invalid value
    }
    val textColor = when (style.lowercase()) {
        "primary" -> LettersAndIcons
        "secondary" -> Color(0xFF0E3E3E) // Darker teal for secondary state
        else -> LettersAndIcons // Default to primary if invalid value
    }

    Box(
        modifier = modifier
            .width(207.dp)
            .height(46.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(30.dp)
            )
            .clip(RoundedCornerShape(30.dp))
            .clickable(enabled = enabled) {
                if (enabled) {
                    onClick()
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                lineHeight = 22.sp,
                textAlign = TextAlign.Center
            ),
            color = textColor,
            textAlign = TextAlign.Center
        )
    }
}