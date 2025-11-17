package ro.alexmamo.roomjetpackcompose.navigation

import kotlinx.serialization.Serializable
import ro.alexmamo.roomjetpackcompose.domain.model.Book

@Serializable
object BookListScreen

@Serializable
object HomeScreen

@Serializable
object ProfileScreen

@Serializable
object SettingsScreen

@Serializable
object AnalyticsScreen

@Serializable
object SwapScreen

@Serializable
object LayersScreen

@Serializable
object LaunchScreen

@Serializable
object LoginScreen

@Serializable
object SignUpScreen

@Serializable
data class BookDetails(
    val id: Int,
    val title: String,
    val author: String
)

fun BookDetails.toBook() = Book(
    id = this.id,
    title = this.title,
    author = this.author
)