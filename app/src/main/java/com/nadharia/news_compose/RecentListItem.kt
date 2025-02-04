package com.nadharia.news_compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.outlined.DownloadDone
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nadharia.news_compose.model.RecentListItem

@Composable
fun RecentList(item: RecentListItem) {
    Card(
        modifier = Modifier.padding(10.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 6.dp
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .weight(2f)
            ) {
                Text(
                    text = item.title,
                    style = TextStyle(
                        color = Color(0xFF5c5c5c),
                        fontWeight = FontWeight.W600,
                        fontSize = 16.sp
                    )
                )
                Text(
                    text = item.subtitle,
                    style = TextStyle(color = Color(0xFF5c5c5c))
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = if (item.isFav) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "",
                    tint = Color(0xFFE93224)
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = if (item.isSaved) Icons.Outlined.DownloadDone else Icons.Filled.Download,
                    contentDescription = "",
                    tint = Color(0xFF757474)
                )
            }
        }
    }
}
