package ro.alexmamo.roomjetpackcompose.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.presentation.home.components.*
import ro.alexmamo.roomjetpackcompose.presentation.home.components.Period
import ro.alexmamo.roomjetpackcompose.ui.theme.*
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun HomeScreen() {
    var selectedPeriod by remember { mutableStateOf(Period.Monthly) }

    val transactions = remember {
        listOf(
            Transaction(
                title = "Salary",
                amount = "$4.000,00",
                category = "saving",
                date = "18:27 - April 30",
                iconColor = LightBlueButton,
                isExpense = false
            ),
            Transaction(
                title = "Groceries",
                amount = "-$100,00",
                category = "groceries",
                date = "17:00 - April 24",
                iconColor = BlueButton,
                isExpense = true
            ),
            Transaction(
                title = "Rent",
                amount = "-$674,40",
                category = "rent",
                date = "8:30 - April 15",
                iconColor = OceanBlue,
                isExpense = true
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MainGreen)
    ) {
        GreetingSection()

        BalanceSection()

        SavingsProgressBar(
            percentage = 30,
            goalAmount = "$20,000.00",
            savedAmount = "$7,783.00"
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                .background(Color.White)
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 24.dp, top = 24.dp, end = 24.dp)
            ) {
                WeeklySummarySection()

                Spacer(modifier = Modifier.height(6.dp))

                PeriodSwitch(
                    selectedPeriod = selectedPeriod,
                    onPeriodSelected = { selectedPeriod = it }
                )

                Spacer(modifier = Modifier.height(6.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(bottom = 100.dp)
                ) {
                    items(transactions) { transaction ->
                        TransactionItem(transaction = transaction)
                    }
                }
            }
        }
    }
}
