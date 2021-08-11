package com.example.navigation

import com.example.commoncore.Screen
import com.example.data.Action

object NavigationDirections {
    fun toMovieDetail(action: Action): NavigationCommand {
        return NavigationCommand(
            destination = Screen.MovieDetail.createRoute(movieId = action.dataId!!)
        )
    }

    fun toMovieList(): NavigationCommand {
        return NavigationCommand(
            destination = Screen.MovieListRoot.route
        )
    }
}