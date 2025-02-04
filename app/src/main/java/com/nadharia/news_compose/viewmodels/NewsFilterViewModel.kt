package com.nadharia.news_compose.viewmodels

import androidx.lifecycle.ViewModel
import com.nadharia.news_compose.data.network.NewsRepo
import com.nadharia.news_compose.model.RecentListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class NewsFilterViewModel @Inject constructor(
    private val newsRepository: NewsRepo,
) :
    ViewModel() {
    private val _recentList = MutableStateFlow(
        listOf(
            RecentListItem(1, "Blue-tailed Bee-eater", "Lorem ipsum", isFav = true, isSaved = true),
            RecentListItem(2, "Indian Peafowl", "Lorem ipsum", isSaved = true),
            RecentListItem(3, "Brahminy Starling", "Lorem ipsum", isFav = true),
            RecentListItem(4, "Chestnut-headed Bee-eater", "Lorem ipsum"),
            RecentListItem(5, "Changeable Hawk-eagle", "Lorem ipsum", isSaved = true),
        )
    )

    val recentList: StateFlow<List<RecentListItem>> = _recentList
}

