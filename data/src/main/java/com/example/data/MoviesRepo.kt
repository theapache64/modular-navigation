package com.example.data

import kotlinx.coroutines.delay
import javax.inject.Inject

class MoviesRepo @Inject constructor() {
    suspend fun getMovies(): List<WidgetItem> {
        return mutableListOf<WidgetItem>().apply {
            delay(2000)
            repeat(50) {
                add(
                    WidgetItem(
                        title = "Movie $it",
                        onClick = Action(
                            type = "to_page",
                            uri = "/in/movies/$it"
                        )
                    )
                )
            }
        }
    }
}