package ro.alexmamo.roomjetpackcompose.presentation.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.components.ScreenHeader
import ro.alexmamo.roomjetpackcompose.presentation.home.components.BalanceSection
import ro.alexmamo.roomjetpackcompose.presentation.home.components.GreetingSection
import ro.alexmamo.roomjetpackcompose.presentation.home.components.SavingsProgressBar
import ro.alexmamo.roomjetpackcompose.presentation.home.components.TransactionIcon
import ro.alexmamo.roomjetpackcompose.presentation.swap.components.TransactionsBalance
import ro.alexmamo.roomjetpackcompose.ui.theme.*
@Composable
fun CategoriesScreen(categories: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MainGreen)
    ) {
        ScreenHeader("Categories")

        GreetingSection()

        BalanceSection(
            totalBalance  = "$7,783.00",
            totalExpense = "-$1,187.40"
        )
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
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 24.dp, top = 24.dp, end = 24.dp)
            ) {
                CategoriesContent(categories = categories)
            }
        }
    }
}

@Composable
fun CategoriesContent(
    categories: List<String>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Iteramos de a 3 para formar filas
        categories.chunked(3).forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                rowItems.forEach { categoryName ->
                    CategoryItem(
                        categoryName = categoryName,
                        modifier = Modifier.weight(1f)
                    )
                }

                // Si la fila tiene menos de 3 items, agregamos espacios vacíos
                if (rowItems.size < 3) {
                    repeat(3 - rowItems.size) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun CategoryItem(
    categoryName: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.width(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Box azul más grande con el ícono centrado
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color = Color.Unspecified, shape = RoundedCornerShape(50.dp)),
            contentAlignment = Alignment.Center
        ) {
            TransactionIcon(categoryName, modifier = Modifier.size(120.dp))
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = categoryName,
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = DarkText,
            textAlign = TextAlign.Center
        )
    }
}







