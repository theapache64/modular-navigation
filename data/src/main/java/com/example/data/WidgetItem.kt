package com.example.data

class WidgetItem(
    val title: String,
    val onClick: Action
)

data class Action(
    val type: String,
    val uri: String
)
