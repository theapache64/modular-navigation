package com.example.movielist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.commoncore.Resource
import com.example.data.WidgetItem

@Composable
fun MovieListScreen(
    viewModel: MovieListViewModel
) {
    val movies by viewModel.movies.collectAsState()
    MovieListUi(movies)
}


@Composable
private fun MovieListUi(
    movies: Resource<List<WidgetItem>>
) {
    when (movies) {
        is Resource.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Loading movies...")
            }
        }
        is Resource.Success -> {
            Movies(movies.data)
        }
        is Resource.Error -> TODO()
        is Resource.Idle -> TODO()
    }


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Movies(movies: List<WidgetItem>) {
    LazyVerticalGrid(cells = GridCells.Adaptive(minSize = 128.dp)) {
        items(movies) { movie ->
            Box(
                modifier = Modifier
                    .height(100.dp)
                    .padding(5.dp)
                    .background(Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                Text(text = movie.title)
            }
        }
    }
}
