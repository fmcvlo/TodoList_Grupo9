package ro.alexmamo.roomjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ro.alexmamo.roomjetpackcompose.presentation.launch.LaunchScreen
import ro.alexmamo.roomjetpackcompose.presentation.login.LoginScreen
import ro.alexmamo.roomjetpackcompose.presentation.signup.SignUpScreen

@Composable
fun AuthNavGraph(
    navController: NavHostController,
    onNavigateToAuthenticated: () -> Unit = {}
) {
    NavHost(
        navController = navController,
        startDestination = LaunchScreen
    ) {
        composable<LaunchScreen> {
            LaunchScreen(
                onLogInClick = {
                    navController.navigate(LoginScreen) {
                        // Evitar que se pueda volver a LaunchScreen con el botón back
                        popUpTo(LaunchScreen) { inclusive = true }
                    }
                },
                onSignUpClick = {
                    navController.navigate(SignUpScreen) {
                        popUpTo(LaunchScreen) { inclusive = true }
                    }
                },
                onForgotPasswordClick = {
                    // TODO: Navegar a ForgotPasswordScreen cuando se implemente
                }

            )
        }
        composable<LoginScreen> {
            LoginScreen(
                onLoginSuccess = {
                    // Cuando el login sea exitoso, navegar a la pantalla autenticada
                    onNavigateToAuthenticated()
                },
                onNavigateToSignUp = {
                    navController.navigate(SignUpScreen)
                },
                onNavigateToForgotPassword = {
                    // TODO: Navegar a ForgotPasswordScreen cuando se implemente
                }
            )
        }
        composable<SignUpScreen> {
            SignUpScreen(
                onSignUpSuccess = {
                    // Cuando el registro sea exitoso, navegar a la pantalla autenticada
                    onNavigateToAuthenticated()
                },
                onNavigateToLogin = {
                    navController.navigate(LoginScreen) {
                        popUpTo(SignUpScreen) { inclusive = true }
                    }
                }
            )
        }
    }
}

