package ro.alexmamo.roomjetpackcompose.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.ui.theme.*

@Composable
fun SavingsProgressBar(
    percentage: Int = 30,
    goalAmount: String = "$20,000.00",
    savedAmount: String = "$7,783.00"
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 38.dp, vertical = 12.dp)
    ) {


        // Progress bar container
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(27.dp)
                .clip(RoundedCornerShape(13.5.dp))
                .background(BackgroundGreenWhite) // Background is now light green/white
        ) {
            // Progress indicator (filled portion - black)
            Box(
                modifier = Modifier
                    .fillMaxWidth(fraction = percentage / 100f)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(13.5.dp))
                    .background(DarkText) // Progress is now dark
            )

            // Text overlay
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Percentage text on top of the dark bar
                Text(
                    text = "$percentage%",
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = BackgroundGreenWhite // Light text on dark background
                )

                // Goal amount text on top of the light bar
                Text(
                    text = goalAmount,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 13.sp,
                    color = DarkText, // Dark text on light background
                    style = androidx.compose.ui.text.TextStyle(
                        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.check),
                contentDescription = "Salary Icon",
            )
            Text(
                text = "$percentage% of your expenses, looks good.",
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                color = DarkText,
                modifier = Modifier.weight(1f)
            )
        }


    }
}