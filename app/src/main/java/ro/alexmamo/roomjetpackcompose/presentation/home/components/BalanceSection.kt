package ro.alexmamo.roomjetpackcompose.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.ui.theme.*

@Composable
fun BalanceSection(
    totalBalance: String = "$7,783.00",
    totalExpense: String = "-$1.187.40"
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 38.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    painter = painterResource(id = R.drawable.income),
                    contentDescription = "income",
                    modifier = Modifier.size(12.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Total Balance",
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = LettersAndIcons
                )
            }

            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = totalBalance,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = BackgroundGreenWhite
            )
        }
        
        // Divider
        Box(
            modifier = Modifier
                .width(1.dp)
                .height(42.dp)
                .background(Color.Gray.copy(alpha = 0.3f))
        )
        
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    painter = painterResource(id = R.drawable.expense),
                    contentDescription = "income",
                    modifier = Modifier.size(12.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Total Expense",
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = LettersAndIcons
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = totalExpense,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                color = OceanBlue
            )
        }
    }
}