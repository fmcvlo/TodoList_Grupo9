package ro.alexmamo.roomjetpackcompose.presentation.swap

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ro.alexmamo.roomjetpackcompose.components.LoadingIndicator
import ro.alexmamo.roomjetpackcompose.domain.model.Response
import ro.alexmamo.roomjetpackcompose.domain.model.Transaction
import ro.alexmamo.roomjetpackcompose.navigation.Screen
import ro.alexmamo.roomjetpackcompose.presentation.home.HomeViewModel
import ro.alexmamo.roomjetpackcompose.presentation.home.components.BalanceSection
import ro.alexmamo.roomjetpackcompose.presentation.home.components.GreetingSection
import ro.alexmamo.roomjetpackcompose.presentation.home.components.Period
import ro.alexmamo.roomjetpackcompose.presentation.home.components.SavingsProgressBar
import ro.alexmamo.roomjetpackcompose.presentation.home.components.TransactionItem
import ro.alexmamo.roomjetpackcompose.presentation.home.mapper.TransactionUiMapper.toUiTransactions
import ro.alexmamo.roomjetpackcompose.ui.theme.MainGreen
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.components.ScreenHeader
import ro.alexmamo.roomjetpackcompose.presentation.swap.components.TransactionsBalance

@Composable
fun TransactionsScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val transactionsState by viewModel.transactionsState.collectAsState()

    when (val state = transactionsState) {
        is Response.Loading -> LoadingIndicator()

        is Response.Success<List<Transaction>> -> {
            val transactions = state.data.toUiTransactions()
            TransactionsScreenContent(transactions = transactions)
        }

        is Response.Failure -> {
            TransactionsScreenContent(transactions = emptyList())
        }

        else -> Unit
    }
}


@Composable
fun TransactionsScreenContent(
    transactions: List<ro.alexmamo.roomjetpackcompose.presentation.home.components.Transaction>
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MainGreen)
    ) {
        ScreenHeader("Transactions")
        TransactionsBalance(
            balance = "$7,783.00",
            income = "$9,500.00",
            expense = "-$1,187.40"
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                .background(Color.White)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 24.dp, top = 24.dp, end = 24.dp)
            ) {

                if (transactions.isEmpty()) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "No hay transacciones",
                            color = _root_ide_package_.ro.alexmamo.roomjetpackcompose.ui.theme.DarkText
                        )
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(bottom = 100.dp)
                    ) {
                        item {
                            Text(
                                text = "April",
                                fontSize = 16.sp,
                                color = Color.Gray,
                                modifier = Modifier
                                    .padding(bottom = 8.dp)
                                    .align(Alignment.Start)
                            )
                        }
                        items(transactions) { transaction ->
                            TransactionItem(transaction = transaction)
                        }
                        item {
                            Spacer(modifier = Modifier.height(24.dp))
                        }

                        item {
                            Text(
                                text = "March",
                                fontSize = 16.sp,
                                color = Color.Gray,
                                modifier = Modifier
                                    .padding(bottom = 8.dp)
                                    .align(Alignment.Start)
                            )
                        }
                        items(transactions) { transaction ->
                            TransactionItem(transaction = transaction)
                        }
                    }
                }
            }
        }
    }
}











