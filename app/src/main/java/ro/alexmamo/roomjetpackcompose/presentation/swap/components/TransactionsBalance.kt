package ro.alexmamo.roomjetpackcompose.presentation.swap.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
fun TransactionsBalance(
    balance: String,
    income: String,
    expense: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp) // menos padding externo
    ) {
        // ------------------ BALANCE CARD ------------------
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Total Balance",
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = LettersAndIcons
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = balance,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = DarkText
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp)) // menos espacio

        // ------------------ INCOME & EXPENSE CARDS ------------------
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp) // menos espacio entre cards
        ) {
            // --- INCOME CARD ---
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp) // menos padding interno
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.income),
                        contentDescription = "Income",
                        modifier = Modifier.size(20.dp), // más pequeño
                        tint = MainGreen
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Income",
                        fontFamily = PoppinsFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp, // más pequeño
                        color = LettersAndIcons
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = income,
                        fontFamily = PoppinsFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp, // más pequeño
                        color = DarkText
                    )
                }
            }

            // --- EXPENSE CARD ---
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.expense),
                        contentDescription = "Expense",
                        modifier = Modifier.size(20.dp),
                        tint = OceanBlue
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Expense",
                        fontFamily = PoppinsFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = LettersAndIcons
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = expense,
                        fontFamily = PoppinsFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = OceanBlue
                    )
                }
            }
        }
    }
}



