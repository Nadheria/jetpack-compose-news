package com.nadharia.news_compose.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khush.newsapp.common.dispatcher.DispatcherProvider
import com.khush.newsapp.common.networkhelper.NetworkHelper
import com.nadharia.news_compose.common.NoInternetException
import com.nadharia.news_compose.base.UIState
import com.nadharia.news_compose.data.network.NewsRepo
import com.nadharia.news_compose.model.NewsType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsFilterViewModel @Inject constructor(
    private val newsRepository: NewsRepo,
    private val dispatcherProvider: DispatcherProvider,
    private val networkHelper: NetworkHelper
) :
    ViewModel() {
    private val _newsTypeItem = MutableStateFlow<UIState<List<NewsType>>>(UIState.Empty)
    val newsTypeItem: StateFlow<UIState<List<NewsType>>> = _newsTypeItem


    fun getNewsType() {
        viewModelScope.launch {
            if (!networkHelper.isNetworkConnected()) {
                _newsTypeItem.emit(
                    UIState.Failure(
                        throwable = NoInternetException()
                    )
                )
                return@launch
            }
            _newsTypeItem.emit(UIState.Loading)
            newsRepository.getCountries()
                .flowOn(dispatcherProvider.io)
                .catch {
                    _newsTypeItem.emit(UIState.Failure(it))
                }
                .collect {
                    _newsTypeItem.emit(UIState.Success(it))
                }
        }
    }
}

