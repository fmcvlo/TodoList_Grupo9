package ro.alexmamo.roomjetpackcompose.presentation.home.mapper

import ro.alexmamo.roomjetpackcompose.domain.model.Transaction
import ro.alexmamo.roomjetpackcompose.presentation.home.components.Transaction as UiTransaction
import ro.alexmamo.roomjetpackcompose.ui.theme.*
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Mapper para convertir Transaction de dominio a Transaction de UI
 */
object TransactionUiMapper {
    
    private val currencyFormatter = NumberFormat.getCurrencyInstance(Locale("es", "AR"))
    
    /**
     * Convierte Transaction de dominio a Transaction de UI
     */
    fun Transaction.toUiTransaction(): UiTransaction {
        val formattedAmount = formatAmount(amount, currency, isExpense)
        val formattedDate = formatDate(date)
        val iconColor = getIconColor(subtype)
        
        return UiTransaction(
            title = description,
            amount = formattedAmount,
            category = subtype,
            date = formattedDate,
            iconColor = iconColor,
            isExpense = isExpense
        )
    }
    
    /**
     * Convierte lista de Transaction de dominio a lista de Transaction de UI
     */
    fun List<Transaction>.toUiTransactions(): List<UiTransaction> {
        return this.map { it.toUiTransaction() }
    }
    
    private fun formatAmount(amount: Double, currency: String, isExpense: Boolean): String {
        val sign = if (isExpense) "-" else ""
        return "$sign${currencyFormatter.format(amount)}"
    }
    
    private fun formatDate(dateString: String): String {
        return try {
            // Intentar parsear formato ISO 8601 (2024-10-01)
            val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val outputFormat = SimpleDateFormat("HH:mm - MMMM dd", Locale.getDefault())
            val date = inputFormat.parse(dateString)
            date?.let { outputFormat.format(it) } ?: dateString
        } catch (e: Exception) {
            dateString // Si falla, devolver el string original
        }
    }
    
    private fun getIconColor(subtype: String): androidx.compose.ui.graphics.Color {
        return when (subtype.lowercase()) {
            "food" -> BlueButton
            "groceries" -> BlueButton
            "clothes" -> OceanBlue
            "services" -> LightBlueButton
            "savings" -> LightBlueButton
            "rent" -> OceanBlue
            else -> OceanBlue
        }
    }
}

