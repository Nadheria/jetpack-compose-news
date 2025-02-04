package com.nadharia.news_compose.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.vector.ImageVector
import com.nadharia.news_compose.Categories
import com.nadharia.news_compose.Source


sealed class TabScreen(val title: String, val icon: ImageVector) {
    object Categories : TabScreen("Categories ", Icons.Filled.Categories)
    object Source : TabScreen("Source", Icons.Filled.Source)
}
