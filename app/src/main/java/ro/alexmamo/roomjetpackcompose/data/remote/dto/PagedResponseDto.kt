package ro.alexmamo.roomjetpackcompose.data.remote.dto

import com.google.gson.annotations.SerializedName

/**
 * DTO para respuestas paginadas de la API
 * Este es el formato que espera recibir desde el servidor
 */
data class PagedResponseDto<T>(
    @SerializedName("data")
    val data: List<T>,
    
    @SerializedName("page")
    val page: Int,
    
    @SerializedName("pageSize")
    val pageSize: Int,
    
    @SerializedName("totalItems")
    val totalItems: Int,
    
    @SerializedName("totalPages")
    val totalPages: Int,
    
    @SerializedName("hasNext")
    val hasNext: Boolean,
    
    @SerializedName("hasPrevious")
    val hasPrevious: Boolean
)

