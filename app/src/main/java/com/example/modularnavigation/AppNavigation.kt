package com.example.modularnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.commoncore.Screen
import com.example.movielist.addMovieListNavGraph

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MovieListRoot.route) {
        addMovieListNavGraph(
            route = Screen.MovieListRoot.route
        )
    }
}