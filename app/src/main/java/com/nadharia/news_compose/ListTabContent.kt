package com.nadharia.news_compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.nadharia.news_compose.model.RecentListItem

@Composable
fun ListTabContent(
    list: List<RecentListItem>,
    filter: (RecentListItem) -> Boolean
) {
    LazyColumn(verticalArrangement = Arrangement.Top) {
        items(list.filter(filter)) { item ->
            RecentList(item)
        }
    }
}
