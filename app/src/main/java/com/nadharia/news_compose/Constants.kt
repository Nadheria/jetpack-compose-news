package com.nadharia.news_compose

import com.example.news_compse.R
import com.nadharia.news_compose.model.NewsType
import org.intellij.lang.annotations.Language

object Constants {

    val BASE_URL = "https://tbr.bonusbuddy.net/"

    val NewsTypeList = listOf(
        NewsType(R.drawable.ic_business,"Business", "ar","",""),
        NewsType(R.drawable.ic_sports,"Sports", "ar","",""),
        NewsType(R.drawable.ic_topheadline,"Top HeadLines", "ar","",""),
        NewsType(R.drawable.ic_health,"Health", "ar","",""),


    )
}