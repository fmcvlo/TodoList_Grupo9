package ro.alexmamo.roomjetpackcompose.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.toRoute

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        Screen.Home to HomeScreen,
        Screen.Profile to ProfileScreen,
        Screen.Settings to SettingsScreen
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        items.forEach { (screen, route) ->
            val isSelected = try {
                val currentRoute = navBackStackEntry?.toRoute<Any>()
                currentRoute != null && currentRoute.javaClass == route.javaClass
            } catch (e: Exception) {
                false
            }
            
            NavigationBarItem(
                label = { Text(screen.title) },
                icon = { Icon(screen.icon, contentDescription = screen.title) },
                selected = isSelected,
                onClick = {
                    navController.navigate(route) {
                        val startDestinationRoute = navController.graph.startDestinationRoute
                        if (startDestinationRoute != null) {
                            popUpTo(startDestinationRoute) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
