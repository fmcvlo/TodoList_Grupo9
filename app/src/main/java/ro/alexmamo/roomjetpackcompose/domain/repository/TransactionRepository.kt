package ro.alexmamo.roomjetpackcompose.domain.repository

import ro.alexmamo.roomjetpackcompose.domain.model.Transaction

interface TransactionRepository {
    suspend fun getTransactions(): List<Transaction>
}

