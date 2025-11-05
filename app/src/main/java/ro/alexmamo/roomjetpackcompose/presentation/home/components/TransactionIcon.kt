package ro.alexmamo.roomjetpackcompose.presentation.home.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.R

@Composable
fun TransactionIcon(
    category: String
) {
    @DrawableRes val iconRes: Int = when (category.lowercase()) {
        "food" -> R.drawable.trans_food
        "transport" -> R.drawable.transport
        "groceries" -> R.drawable.groceries
        "rent" -> R.drawable.rent
        "gifts" -> R.drawable.gifts
        "medicine" -> R.drawable.medicine
        "entertainment" -> R.drawable.entretainment
        "saving" -> R.drawable.saving
        else -> R.drawable.food
    }
    Icon(
        painter = painterResource(id = iconRes),
        contentDescription = "Transaction Icon: $category",
        modifier = Modifier.size(54.dp),
        tint = Color.Unspecified
    )
}