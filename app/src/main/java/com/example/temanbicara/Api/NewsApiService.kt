package com.example.temanbicara.Api


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("everything")
    fun getTopHeadlines(
        @Query("q") q:String,
        @Query("apiKey") apiKey: String
    ): Call<NewsResponse>
}
