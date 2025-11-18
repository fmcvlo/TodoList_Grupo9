package ro.alexmamo.roomjetpackcompose.data.remote.dto

import com.google.gson.annotations.SerializedName

/**
 * DTO genérico para la respuesta completa de la API de transacciones
 * Mapea la estructura JSON que viene del servidor
 * 
 * @param T Tipo de los elementos en la lista de transacciones
 */
data class TransactionsResponseDto<T>(
    @SerializedName("user_id")
    val userId: Int,
    
    @SerializedName("balance")
    val balance: Double,
    
    @SerializedName("income")
    val income: Double,
    
    @SerializedName("expense")
    val expense: Double,
    
    @SerializedName("transactions")
    val transactions: List<T>
)

