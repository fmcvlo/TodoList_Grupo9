package ro.alexmamo.roomjetpackcompose.domain.model

/**
 * Entidad de dominio para Transaction
 * Representa una transacción financiera en la capa de dominio
 */
data class Transaction(
    val transactionId: String,
    val date: String,
    val description: String,
    val amount: Double,
    val currency: String,
    val type: String, // "expense" o "income"
    val subtype: String // "food", "clothes", "services", "savings", etc.
) {
    /**
     * Propiedad calculada para compatibilidad con la UI existente
     */
    val isExpense: Boolean
        get() = type == "expense"
    
    /**
     * Propiedad calculada para compatibilidad con la UI existente
     */
    val title: String
        get() = description
    
    /**
     * Propiedad calculada para compatibilidad con la UI existente
     */
    val category: String
        get() = subtype
}

