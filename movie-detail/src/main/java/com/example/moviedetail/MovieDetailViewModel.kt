package com.example.moviedetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.commoncore.Resource
import com.example.data.MoviesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    moviesRepo: MoviesRepo

) : ViewModel() {
    private val _movieDetail = MutableStateFlow<Resource<String>>(Resource.Idle())
    val movieDetail = _movieDetail.asStateFlow()

    init {
        val movieId = savedStateHandle.get<String>("movieId")!!
        viewModelScope.launch {
            _movieDetail.value = Resource.Loading()
            _movieDetail.value = Resource.Success(moviesRepo.getDetail(movieId))
        }
    }
}