package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.ui.theme.DarkText
import ro.alexmamo.roomjetpackcompose.ui.theme.PoppinsFontFamily

@Composable
fun ClickableText(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    color: androidx.compose.ui.graphics.Color = DarkText,
    fontSize: androidx.compose.ui.unit.TextUnit = 14.sp,
    fontWeight: FontWeight = FontWeight.SemiBold
) {
    Text(
        text = text,
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        fontFamily = PoppinsFontFamily,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = color,
        textAlign = textAlign
    )
}

@Preview
@Composable
fun ClickableTextPreview() {
    ClickableText(
        text = "Forgot Password?",
        onClick = {}
    )
}

