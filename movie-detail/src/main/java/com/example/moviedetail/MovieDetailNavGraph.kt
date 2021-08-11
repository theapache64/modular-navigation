package com.example.moviedetail

import androidx.compose.material.Text
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.commoncore.Screen

fun NavGraphBuilder.addMovieDetailNavGraph(
    route: String
) {
    navigation(route = route, startDestination = Screen.MovieDetail.createRoute("AAA")) {

        composable(route = "error") {
            Text(text = "This graph cannot be started directly")
        }

        composable(Screen.MovieDetail.route) {
            MovieDetailScreen(viewModel = hiltViewModel())
        }
    }
}