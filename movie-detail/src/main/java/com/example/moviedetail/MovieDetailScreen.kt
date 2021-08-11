package com.example.moviedetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.commoncore.Resource

@Composable
fun MovieDetailScreen(
    viewModel: MovieDetailViewModel
) {
    val movieDetail by viewModel.movieDetail.collectAsState()
    MovieDetailScreen(movieDetail)
}

@Composable
fun MovieDetailScreen(
    movieDetail: Resource<String>
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (movieDetail) {
            is Resource.Loading -> {
                Text(text = "Loading movie detail")
            }
            is Resource.Success -> {
                Text(text = "Movie Detail : '${movieDetail.data}'", fontSize = 25.sp)
            }
            is Resource.Error -> TODO()
            is Resource.Idle -> {

            }
        }
    }
}