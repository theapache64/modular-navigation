package com.example.commoncore

sealed class Screen(val route: String) {
    object Splash : Screen("splash")

    object MovieListRoot : Screen("movieListRoot")
    object MovieList : Screen("movies")

    object MovieDetailRoot : Screen("movieDetailRoot")
    object MovieDetail : Screen("movieDetail/{movieId}") {
        fun createRoute(movieId: String) = "movieDetail/$movieId"
    }
}