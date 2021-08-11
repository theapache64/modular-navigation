package com.example.modularnavigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.commoncore.Screen
import com.example.modularnavigation.splash.SplashScreen
import com.example.moviedetail.addMovieDetailNavGraph
import com.example.movielist.addMovieListNavGraph
import com.example.navigation.NavigationManager

@Composable
fun AppNavigation(navigationManager: NavigationManager) {
    val navController = rememberNavController()

    navigationManager.commands.collectAsState().value?.let {
        navController.navigate(it.destination)
    }


    NavHost(navController = navController, startDestination = Screen.Splash.route) {

        composable(Screen.Splash.route) {
            SplashScreen(splashViewModel = hiltViewModel())
        }


        addMovieListNavGraph(
            route = Screen.MovieListRoot.route
        )

        addMovieDetailNavGraph(
            route = Screen.MovieDetailRoot.route
        )
    }
}