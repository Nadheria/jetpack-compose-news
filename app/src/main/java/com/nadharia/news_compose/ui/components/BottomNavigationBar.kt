package com.nadharia.news_compose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.news_compse.R
import java.util.Locale

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf("news", "filter", "saved", "search")
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.surface, // Default background
        contentColor = MaterialTheme.colors.onSurface, // Default content color
        elevation = 8.dp
    ) {
        val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route
        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = getIcon(screen)),
                            contentDescription = screen,
                            modifier = Modifier.size(24.dp) // Adjust icon size if needed
                        )
                        Spacer(modifier = Modifier.height(4.dp)) // Space between icon and text
                    }
                },
                label = {
                    Text(
                        text = screen.capitalize(Locale.ROOT),
                        style = MaterialTheme.typography.caption // Default text style
                    )
                },
                selected = currentDestination == screen,
                onClick = {
                    navController.navigate(screen) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                selectedContentColor = MaterialTheme.colors.primary, // Highlight selected tab
                unselectedContentColor = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium)
            )
        }
    }
}


@Composable
fun getIcon(screen: String): Int {
    return when (screen) {
        "news" -> R.drawable.ic_news
        "filter" -> R.drawable.ic_filter
        "saved" -> R.drawable.ic_save
        "search" -> R.drawable.ic_search
        else -> R.drawable.ic_news
    }
}
