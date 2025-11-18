package ro.alexmamo.roomjetpackcompose.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import ro.alexmamo.roomjetpackcompose.data.remote.dto.TransactionDto
import ro.alexmamo.roomjetpackcompose.data.remote.dto.TransactionsResponseDto

/**
 * Interfaz Retrofit para consumir la API de Transactions
 * Define los endpoints
 */
interface TransactionApiService {
    /**
     * Obtiene las transacciones del usuario
     * 
     * @return Response con TransactionsResponseDto que contiene balance, income, expense y transactions
     */
    @GET("transactions")
    suspend fun getTransactions(): Response<TransactionsResponseDto<TransactionDto>>
}   

