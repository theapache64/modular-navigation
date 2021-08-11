package com.example.navigation

import com.example.data.Action
import kotlinx.coroutines.flow.MutableStateFlow

class NavigationManager {

    var commands = MutableStateFlow<NavigationCommand?>(null)

    fun navigate(action: Action) {
        commands.value = when (action.type) {
            Action.ACTION_TYPE_TO_DETAIL -> {
                NavigationDirections.toMovieDetail(action)
            }
            Action.ACTION_TYPE_TO_MOVIE_LIST -> {
                NavigationDirections.toMovieList()
            }
            else -> throw IllegalArgumentException("undefined navigation action type")
        }
    }
}