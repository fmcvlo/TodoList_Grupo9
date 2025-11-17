package ro.alexmamo.roomjetpackcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ro.alexmamo.roomjetpackcompose.navigation.AuthNavGraph
import ro.alexmamo.roomjetpackcompose.ui.theme.RoomJetpackComposeTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoomJetpackComposeTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    var isAuthenticated by remember { mutableStateOf(false) }

    if (isAuthenticated) {
        // Mostrar pantalla autenticada (la antigua MainScreen)
        AuthenticatedScreen()
    } else {
        // Mostrar navegación de autenticación (LaunchScreen -> LoginScreen)
        AuthNavGraph(
            navController = navController,
            onNavigateToAuthenticated = {
                isAuthenticated = true
            }
        )
    }
}
