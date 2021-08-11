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
                            type = Action.ACTION_TYPE_TO_DETAIL,
                            dataId = "movieId_$it"
                        )
                    )
                )
            }
        }
    }

    suspend fun getDetail(movieId: String): String {
        delay(2000)
        return "THE DETAIL FOR MOVIE ID '$movieId'"
    }
}