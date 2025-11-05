package ro.alexmamo.roomjetpackcompose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import ro.alexmamo.roomjetpackcompose.R

sealed class Screen(
    val route: String,
    val title: String,
    val icon: Int,
    val selectedIcon: Int
) {
    object Home : Screen(
        route = "home_screen",
        title = "Inicio",
        icon = R.drawable.home,
        selectedIcon = R.drawable.home_selected

    )
    object Analytics : Screen(
        route = "analytics_screen",
        title = "Analytics",
        icon = R.drawable.analysis,
        selectedIcon = R.drawable.analysis_selected
    )
    object Swap : Screen(
        route = "swap_screen",
        title = "Swap",
        icon = R.drawable.transaction,
        selectedIcon = R.drawable.transaction_selected
    )
    object Layers : Screen(
        route = "layers_screen",
        title = "Layers",
        icon = R.drawable.category,
        selectedIcon = R.drawable.category_selected
    )
    object Profile : Screen(
        route = "profile_screen",
        title = "Perfil",
        icon = R.drawable.profile,
        selectedIcon = R.drawable.profile_selected
    )
}
