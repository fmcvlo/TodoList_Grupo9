package ro.alexmamo.roomjetpackcompose.data.remote.mapper

import ro.alexmamo.roomjetpackcompose.data.remote.dto.TransactionDto
import ro.alexmamo.roomjetpackcompose.data.remote.dto.TransactionsResponseDto
import ro.alexmamo.roomjetpackcompose.domain.model.Transaction

/**
 * Mapper para convertir DTOs de Transaction a entidades de dominio
 * Separa la capa de datos de la capa de dominio
 */
object TransactionMapper {
    /**
     * Convierte TransactionDto a Transaction (entidad de dominio)
     */
    fun TransactionDto.toDomain(): Transaction {
        return Transaction(
            transactionId = this.transactionId,
            date = this.date,
            description = this.description,
            amount = this.amount,
            currency = this.currency,
            type = this.type,
            subtype = this.subtype
        )
    }
    
    /**
     * Convierte TransactionsResponseDto<TransactionDto> a lista de Transaction
     */
    fun TransactionsResponseDto<TransactionDto>.toDomain(): List<Transaction> {
        return this.transactions.map { it.toDomain() }
    }
    
    /**
     * Convierte lista de TransactionDto a lista de Transaction
     */
    fun List<TransactionDto>.toDomain(): List<Transaction> {
        return this.map { it.toDomain() }
    }
}

