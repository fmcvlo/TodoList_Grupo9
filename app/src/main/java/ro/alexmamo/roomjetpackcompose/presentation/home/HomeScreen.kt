package ro.alexmamo.roomjetpackcompose.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ro.alexmamo.roomjetpackcompose.components.LoadingIndicator
import ro.alexmamo.roomjetpackcompose.domain.model.Response
import ro.alexmamo.roomjetpackcompose.presentation.home.components.*
import ro.alexmamo.roomjetpackcompose.presentation.home.components.Period
import ro.alexmamo.roomjetpackcompose.presentation.home.mapper.TransactionUiMapper.toUiTransactions
import ro.alexmamo.roomjetpackcompose.ui.theme.*
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    var selectedPeriod by remember { mutableStateOf(Period.Monthly) }
    val transactionsState by viewModel.transactionsState.collectAsState()

    when (val state = transactionsState) {
        is Response.Idle -> {}
        is Response.Loading -> {
            LoadingIndicator()
        }
        is Response.Success -> {
            val transactions = state.data.toUiTransactions()
            HomeScreenContent(
                selectedPeriod = selectedPeriod,
                transactions = transactions,
                onPeriodSelected = { selectedPeriod = it }
            )
        }
        is Response.Failure -> {
            // TODO: Mostrar mensaje de error
            HomeScreenContent(
                selectedPeriod = selectedPeriod,
                transactions = emptyList(),
                onPeriodSelected = { selectedPeriod = it }
            )
        }
    }
}

@Composable
private fun HomeScreenContent(
    selectedPeriod: Period,
    transactions: List<ro.alexmamo.roomjetpackcompose.presentation.home.components.Transaction>,
    onPeriodSelected: (Period) -> Unit
) {

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
                    onPeriodSelected = onPeriodSelected
                )

                Spacer(modifier = Modifier.height(6.dp))

                if (transactions.isEmpty()) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = androidx.compose.ui.Alignment.Center
                    ) {
                        androidx.compose.material3.Text(
                            text = "No hay transacciones",
                            color = DarkText
                        )
                    }
                } else {
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
}
