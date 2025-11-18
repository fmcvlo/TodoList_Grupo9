package ro.alexmamo.roomjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ro.alexmamo.roomjetpackcompose.presentation.launch.LaunchScreen
import ro.alexmamo.roomjetpackcompose.presentation.login.LoginScreen
import ro.alexmamo.roomjetpackcompose.presentation.signup.SignUpScreen
import ro.alexmamo.roomjetpackcompose.presentation.forgotpassword.ForgotPasswordScreen

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
                    navController.navigate(LoginScreen)
                },
                onSignUpClick = {
                    navController.navigate(SignUpScreen)
                },
                onForgotPasswordClick = {
                    navController.navigate(ForgotPasswordScreen)
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
                    navController.navigate(ForgotPasswordScreen)
                },
                onNavigateBack = {
                    navController.navigateUp()
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
                    navController.navigate(LoginScreen)
                },
                onNavigateBack = {
                    navController.navigateUp()
                }
            )
        }
        composable<ForgotPasswordScreen> {
            ForgotPasswordScreen(
                onResetPasswordSuccess = {
                    // Cuando el reset de contraseña sea exitoso, navegar a la pantalla autenticada
                    onNavigateToAuthenticated()
                },
                onNavigateToSignUp = {
                    navController.navigate(SignUpScreen)
                },
                onNavigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}

