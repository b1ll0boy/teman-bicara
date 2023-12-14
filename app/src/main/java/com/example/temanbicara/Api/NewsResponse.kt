package com.example.temanbicara.Api

data class NewsResponse(
    val articles: List<Article>
)

data class Article(
    val title: String,
    val description: String,
    val url: String
)
