package ro.alexmamo.roomjetpackcompose.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.ui.theme.*

enum class Period {
    Daily, Weekly, Monthly
}

@Composable
fun PeriodSwitch(
    selectedPeriod: Period = Period.Monthly,
    onPeriodSelected: (Period) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 20.dp)
            .height(60.dp)
            .clip(RoundedCornerShape(22.dp))
            .background(LightGreen)
            .padding(horizontal = 14.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        PeriodButton(
            text = "Daily",
            isSelected = selectedPeriod == Period.Daily,
            onClick = { onPeriodSelected(Period.Daily) }
        )
        PeriodButton(
            text = "Weekly",
            isSelected = selectedPeriod == Period.Weekly,
            onClick = { onPeriodSelected(Period.Weekly) }
        )
        PeriodButton(
            text = "Monthly",
            isSelected = selectedPeriod == Period.Monthly,
            onClick = { onPeriodSelected(Period.Monthly) }
        )
    }
}

@Composable
private fun RowScope.PeriodButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .weight(1f)
            .height(if (isSelected) 50.dp else 31.dp)
            .clip(RoundedCornerShape(if (isSelected) 19.dp else 10.dp))
            .background(if (isSelected) MainGreen else Color.Transparent)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
            color = DarkText
        )
    }
}



