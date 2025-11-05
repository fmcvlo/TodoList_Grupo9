package ro.alexmamo.roomjetpackcompose.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import ro.alexmamo.roomjetpackcompose.navigation.BottomNavigationBar
import ro.alexmamo.roomjetpackcompose.navigation.NavGraph

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        // Aquí asignamos nuestra barra de navegación personalizada
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { innerPadding ->
        // El NavGraph (que controla el contenido) se coloca dentro del Scaffold
        Box(modifier = Modifier.padding(innerPadding)) {
            NavGraph(navController = navController)
        }
    }
}
