package com.example.educateascenders.navigation

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object Login : Screen("login")
    object SignUp : Screen("signup")
    object Home : Screen("home")
    object CategorySelection : Screen("category_selection")
    object SubjectSelection : Screen("subject_selection")
    object SearchResults : Screen("search_results")
} 