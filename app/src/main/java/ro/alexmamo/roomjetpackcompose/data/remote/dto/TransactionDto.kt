package ro.alexmamo.roomjetpackcompose.data.remote.dto

import com.google.gson.annotations.SerializedName

/**
 * DTO para Transaction recibido desde la API
 * Mapea la estructura JSON que viene del servidor
 */
data class TransactionDto(
    @SerializedName("transaction_id")
    val transactionId: String,
    
    @SerializedName("date")
    val date: String,
    
    @SerializedName("description")
    val description: String,
    
    @SerializedName("amount")
    val amount: Double,
    
    @SerializedName("currency")
    val currency: String,
    
    @SerializedName("type")
    val type: String, // "expense" o "income"
    
    @SerializedName("subtype")
    val subtype: String // "food", "clothes", "services", "savings", etc.
)

