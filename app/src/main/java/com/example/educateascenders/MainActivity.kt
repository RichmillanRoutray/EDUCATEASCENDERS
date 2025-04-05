package com.example.educateascenders

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.educateascenders.navigation.Screen
import com.example.educateascenders.ui.screens.*
import com.example.educateascenders.ui.theme.EducateAscendersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EducateAscendersTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.Welcome.route
                    ) {
                        composable(Screen.Welcome.route) {
                            WelcomeScreen(navController)
                        }
                        composable(Screen.Login.route) {
                            LoginScreen(navController)
                        }
                        composable(Screen.SignUp.route) {
                            SignUpScreen(navController)
                        }
                        composable(Screen.Home.route) {
                            HomeScreen(navController)
                        }
                        composable(Screen.CategorySelection.route) {
                            CategorySelectionScreen(navController)
                        }
                        composable(Screen.SubjectSelection.route) {
                            SubjectSelectionScreen()
                        }
                        composable(Screen.SearchResults.route) {
                            SearchResultsScreen(navController, this@MainActivity)
                        }
                    }
                }
            }
        }
    }
}
//Removed @Suppress("UNREACHABLE_CODE")
//Removed : Parcelable
class SubjectSelectionScreen {
    //Removed Parcel code

}