package ro.alexmamo.roomjetpackcompose.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.ui.theme.BottomNavActiveBackground
import ro.alexmamo.roomjetpackcompose.ui.theme.DarkGreen
import ro.alexmamo.roomjetpackcompose.ui.theme.LightGreen
// Data class para items del bottom nav
data class BottomNavItem(
    val screen: Any,
    val title: String,
    val icon: Int,
    val routeName: String
)
@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem(
            screen = HomeScreen,
            title = "Inicio",
            icon = R.drawable.home,
            routeName = "HomeScreen"
        ),
        BottomNavItem(
            screen = AnalyticsScreen,
            title = "Analytics",
            icon = R.drawable.analysis,
            routeName = "AnalyticsScreen"
        ),
        BottomNavItem(
            screen = SwapScreen,
            title = "Swap",
            icon = R.drawable.transaction,
            routeName = "SwapScreen"
        ),
        BottomNavItem(
            screen = LayersScreen,
            title = "Layers",
            icon = R.drawable.category,
            routeName = "LayersScreen"
        ),
        BottomNavItem(
            screen = ProfileScreen,
            title = "Perfil",
            icon = R.drawable.profile,
            routeName = "ProfileScreen"
        )
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Box(
        modifier = Modifier.fillMaxWidth().background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 80.dp, topEnd = 80.dp))
                .background(LightGreen)
                .padding(top = 36.dp, bottom = 41.dp, start = 30.dp, end = 30.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val iconSpacing = 33.dp

            items.forEachIndexed { index, item ->
                // Comparar usando el nombre de la ruta
                val isSelected = currentRoute?.contains(item.routeName, ignoreCase = true) == true

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(
                            if (isSelected) BottomNavActiveBackground else Color.Transparent
                        )
                        .clickable {
                            navController.navigate(item.routeName) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                        .padding(horizontal = 8.dp, vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        tint = DarkGreen,
                        modifier = Modifier.size(28.dp)
                    )

                }

                if (index < items.lastIndex) {
                    Spacer(modifier = Modifier.width(iconSpacing))
                }
            }
        }
    }
}
