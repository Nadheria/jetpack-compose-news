package com.nadharia.news_compose.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NewsScreen() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(10) { index ->
            Text(text = "News Item #$index", modifier = Modifier.padding(8.dp))
        }
    }
}
