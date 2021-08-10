package com.example.movielist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.MoviesRepo
import com.example.commoncore.Resource
import com.example.data.WidgetItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val moviesRepo: MoviesRepo
) : ViewModel() {
    private val _movies = MutableStateFlow<Resource<List<WidgetItem>>>(Resource.Idle())
    val movies = _movies.asStateFlow()

    init {
        viewModelScope.launch {
            _movies.value = Resource.Loading()
            _movies.value = Resource.Success(moviesRepo.getMovies())
        }
    }
}