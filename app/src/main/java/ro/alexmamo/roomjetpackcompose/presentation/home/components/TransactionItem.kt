package ro.alexmamo.roomjetpackcompose.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.ui.theme.*

data class Transaction(
    val title: String,
    val amount: String,
    val category: String,
    val date: String,
    val iconColor: androidx.compose.ui.graphics.Color,
    val isExpense: Boolean = true
)

@Composable
fun TransactionItem(
    transaction: Transaction,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(2f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TransactionIcon(transaction.category)

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = transaction.category,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    color = DarkText
                )
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    text = transaction.date,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 10.sp,
                    color = OceanBlue
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .background(MainGreen)
        )

        Box(
            modifier = Modifier
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = transaction.category.replaceFirstChar { it.uppercase() },
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
                color = DarkText
            )
        }

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .background(MainGreen)
        )

        Box(
            modifier = Modifier
                .weight(1f),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = transaction.amount,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 13.sp,
                color = if (!transaction.isExpense) DarkText else OceanBlue
            )
        }
    }
}





