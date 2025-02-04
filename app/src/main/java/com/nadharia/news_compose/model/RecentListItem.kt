package com.nadharia.news_compose.model

data class RecentListItem(
    val id: Int,
    val title: String,
    val subtitle: String,
    val isFav: Boolean = false,
    val isSaved: Boolean = false
)