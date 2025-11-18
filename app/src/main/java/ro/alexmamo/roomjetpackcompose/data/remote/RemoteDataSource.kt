package ro.alexmamo.roomjetpackcompose.data.remote

import ro.alexmamo.roomjetpackcompose.data.remote.api.TransactionApiService
import ro.alexmamo.roomjetpackcompose.data.remote.mapper.TransactionMapper.toDomain
import ro.alexmamo.roomjetpackcompose.domain.model.Transaction
import javax.inject.Inject

/**
 * DataSource remoto para consumir la API de transacciones
 * Maneja las llamadas a la API y convierte DTOs a entidades de dominio
 */
class RemoteDataSource @Inject constructor(
    private val transactionApiService: TransactionApiService
) {
    /**
     * Obtiene las transacciones desde la API
     * 
     * @return Lista de transacciones convertidas a entidades de dominio
     * @throws Exception si hay error en la llamada a la API
     */
    suspend fun getTransactions(): List<Transaction> {
        val response = transactionApiService.getTransactions()
        
        if (response.isSuccessful && response.body() != null) {
            return response.body()!!.toDomain()
        } else {
            throw Exception("Error al obtener transacciones: ${response.code()} - ${response.message()}")
        }
    }
}

