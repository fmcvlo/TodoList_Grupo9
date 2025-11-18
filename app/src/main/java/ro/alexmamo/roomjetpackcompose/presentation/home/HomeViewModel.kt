package ro.alexmamo.roomjetpackcompose.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ro.alexmamo.roomjetpackcompose.domain.model.Response
import ro.alexmamo.roomjetpackcompose.domain.model.Transaction
import ro.alexmamo.roomjetpackcompose.domain.repository.TransactionRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository
) : ViewModel() {
    
    private val _transactionsState = MutableStateFlow<Response<List<Transaction>>>(
        Response.Idle
    )
    val transactionsState: StateFlow<Response<List<Transaction>>> = 
        _transactionsState.asStateFlow()
    
    init {
        loadTransactions()
    }
    
    fun loadTransactions() = viewModelScope.launch {
        _transactionsState.value = Response.Loading
        try {
            val transactions = transactionRepository.getTransactions()
            _transactionsState.value = Response.Success(transactions)
        } catch (e: Exception) {
            _transactionsState.value = Response.Failure(e)
        }
    }
}

