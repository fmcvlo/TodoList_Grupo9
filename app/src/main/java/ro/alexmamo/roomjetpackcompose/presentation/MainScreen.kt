package ro.alexmamo.roomjetpackcompose.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import ro.alexmamo.roomjetpackcompose.navigation.BottomNavigationBar
import ro.alexmamo.roomjetpackcompose.navigation.NavGraph

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        // Aquí asignamos nuestra barra de navegación personalizada
        bottomBar = { BottomNavigationBar(navController = navController) },
        containerColor = Color.Transparent
    ) { innerPadding ->
        // El NavGraph (que controla el contenido) se coloca dentro del Scaffold
        // No aplicamos padding para que el fondo verde se extienda hasta arriba
        // El padding del status bar se maneja dentro de cada screen (ej: GreetingSection)
        // No aplicamos padding inferior para que la card blanca llegue hasta la bottom nav
        Box(modifier = Modifier) {
            NavGraph(navController = navController)
        }
    }
}


