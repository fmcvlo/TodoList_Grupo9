package ro.alexmamo.roomjetpackcompose.domain.model

/**
 * Entidad de dominio para resultados paginados
 * Representa la información de paginación en la capa de dominio
 */
data class PagedResult<T>(
    val data: List<T>,
    val page: Int,
    val pageSize: Int,
    val totalItems: Int,
    val totalPages: Int,
    val hasNext: Boolean,
    val hasPrevious: Boolean
) {
    val isEmpty: Boolean
        get() = data.isEmpty()
    
    val isFirstPage: Boolean
        get() = page == 1
    
    val isLastPage: Boolean
        get() = page >= totalPages
}

