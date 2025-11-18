package ro.alexmamo.roomjetpackcompose.data.repository

import ro.alexmamo.roomjetpackcompose.data.remote.RemoteDataSource
import ro.alexmamo.roomjetpackcompose.domain.model.Transaction
import ro.alexmamo.roomjetpackcompose.domain.repository.TransactionRepository
import javax.inject.Inject

class TransactionRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : TransactionRepository {
    
    override suspend fun getTransactions(): List<Transaction> {
        return remoteDataSource.getTransactions()
    }
}

