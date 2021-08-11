package com.example.modularnavigation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.Action
import com.example.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    navigationManager: NavigationManager
) : ViewModel() {
    init {
        viewModelScope.launch {
            delay(1500)
            navigationManager.navigate(
                Action(
                    type = Action.ACTION_TYPE_TO_MOVIE_LIST,
                    dataId = null
                )
            )
        }
    }
}