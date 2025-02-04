package com.nadharia.news_compose.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nadharia.news_compose.TabBarScreen
import com.nadharia.news_compose.ui.screens.NewsScreen
import com.nadharia.news_compose.ui.screens.SavedScreen
import com.nadharia.news_compose.ui.screens.SearchScreen


@Composable
fun NavigationGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = "news",
        modifier = Modifier.padding(paddingValues)
    ) {
        composable("news") { NewsScreen() }
        composable("filter") { TabBarScreen() }
        composable("saved") { SavedScreen() }
        composable("search") { SearchScreen() }
    }
}
