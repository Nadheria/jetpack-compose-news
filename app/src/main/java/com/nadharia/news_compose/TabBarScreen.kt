package com.nadharia.news_compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.nadharia.news_compose.ui.components.TabScreen
import com.nadharia.news_compose.viewmodels.NewsFilterViewModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabBarScreen(viewModel: NewsFilterViewModel = hiltViewModel()) {
    val tabs = listOf(TabScreen.Categories, TabScreen.Source)
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    val newsCategoryList by viewModel.newsTypeItem.collectAsState()



    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Tab bar demo") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle navigation */ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Navigation menu")
                    }
                },
                backgroundColor = Color.Gray,
                contentColor = Color.White,
                elevation = 0.dp,
                actions = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(
                            Icons.Filled.MoreVert,
                            contentDescription = "Pop up",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            TabRow(
                selectedTabIndex = pagerState.currentPage,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier.pagerTabIndicatorOffset(
                            pagerState,
                            tabPositions
                        )
                    )
                }
            ) {
                tabs.forEachIndexed { index, item ->
                    Tab(
                        selected = pagerState.currentPage == index,
                        onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                        icon = { Icon(imageVector = item.icon, contentDescription = null) },
                        text = { Text(text = item.title, overflow = TextOverflow.Ellipsis) }
                    )
                }
            }

            HorizontalPager(
                state = pagerState, count = tabs.size,
                verticalAlignment = Alignment.Top,
                modifier = Modifier.padding(top = 10.dp)
            ) { page ->
                when (tabs[page]) {
                    TabScreen.Categories -> ListTabContent(newsCategoryList) { true }
                    TabScreen.Source -> ListTabContent(newsCategoryList) { it.isFav }
                }
            }
        }
    }
}


