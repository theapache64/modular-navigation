package com.example.movielist

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.commoncore.Screen

fun NavGraphBuilder.addMovieListNavGraph(
    route: String
) {
    navigation(route = route, startDestination = Screen.MovieList.route) {
        composable(Screen.MovieList.route) {
            MovieListScreen(viewModel = hiltViewModel())
        }
    }
}