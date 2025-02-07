package com.nadharia.news_compose.data.network

import com.nadharia.news_compose.Constants
import com.nadharia.news_compose.model.NewsType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepo @Inject constructor() {

    suspend fun getCountries(): Flow<List<NewsType>> = flow {
        emit(Constants.NewsTypeList)
    }
}
