package ro.alexmamo.roomjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import ro.alexmamo.roomjetpackcompose.domain.model.toBookDetails
import ro.alexmamo.roomjetpackcompose.presentation.book_list.BookListScreen
import ro.alexmamo.roomjetpackcompose.presentation.book_details.BookDetailsScreen
import ro.alexmamo.roomjetpackcompose.presentation.home.HomeScreen
import ro.alexmamo.roomjetpackcompose.presentation.profile.ProfileScreen
import ro.alexmamo.roomjetpackcompose.presentation.settings.SettingsScreen
import ro.alexmamo.roomjetpackcompose.presentation.analytics.AnalyticsScreen
import ro.alexmamo.roomjetpackcompose.presentation.swap.SwapScreen
import ro.alexmamo.roomjetpackcompose.presentation.layers.LayersScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "HomeScreen"
    ) {
        composable("HomeScreen") {
            HomeScreen()
        }
        composable("BookListScreen") {
            BookListScreen(
                navigateToBookDetailsScreen = { book ->
                    val bookDetails = book.toBookDetails()
                    navController.navigate(bookDetails)
                }
            )
        }
        composable("ProfileScreen") {
            ProfileScreen()
        }
        composable("SettingsScreen") {
            SettingsScreen()
        }
        composable("AnalyticsScreen") {
            AnalyticsScreen()
        }
        composable("SwapScreen") {
            SwapScreen()
        }
        composable("LayersScreen") {
            LayersScreen()
        }
        composable<BookDetails> { entry ->
            val bookDetails = entry.toRoute<BookDetails>()
            val book = bookDetails.toBook()
            BookDetailsScreen(
                book = book,
                navigateBack = navController::navigateUp
            )
        }
    }
}