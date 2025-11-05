package ro.alexmamo.roomjetpackcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
// Añade el tema de tu app si no está
import ro.alexmamo.roomjetpackcompose.ui.theme.RoomJetpackComposeTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Es buena práctica envolver todo en tu tema
            RoomJetpackComposeTheme {
                // Simplemente llama a MainScreen aquí
                MainScreen()
            }
        }
    }
}
