package com.example.data

class WidgetItem(
    val title: String,
    val onClick: Action
)

data class Action(
    val type: String,
    val dataId: String?
){
    companion object{
        const val ACTION_TYPE_TO_MOVIE_LIST = "to_movie_list"
        const val ACTION_TYPE_TO_DETAIL = "to_detail"
    }
}
