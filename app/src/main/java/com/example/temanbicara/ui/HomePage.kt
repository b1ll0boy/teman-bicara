package com.example.temanbicara.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.example.temanbicara.Api.Article
import com.example.temanbicara.Api.NewsAdapter
import com.example.temanbicara.Api.NewsResponse
import com.example.temanbicara.Api.RetrofitClient
import com.example.temanbicara.R
import retrofit2.Call
import retrofit2.Callback

class HomePage : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        newsAdapter = NewsAdapter(listOf()) // Initial empty list of news articles
        recyclerView.adapter = newsAdapter

        fetchNews()
    }

    private fun fetchNews() {
        val q = "mental-health"
//        val country = "id" // Change this to the desired country code
        val service = RetrofitClient.instance
        val call = service.getTopHeadlines(q, "9596d8f38aeb495fa112f48a3a3766c2")

        call.enqueue(object : Callback<NewsResponse?> {
            override fun onResponse(
                call: Call<NewsResponse?>,
                response: retrofit2.Response<NewsResponse?>
            ) {
                if (response.isSuccessful) {
                    val articles = response.body()?.articles ?: emptyList()
                    updateUI(articles)
                } else {
                    // Handle unsuccessful response
                    Log.e("NewsAPI", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<NewsResponse?>, t: Throwable) {
                // Handle network failure
                Log.e("NewsAPI", "Network Error: ${t.message}")
            }
        })
    }

    private fun updateUI(articles: List<Article>) {
        newsAdapter = NewsAdapter(articles)
        recyclerView.adapter = newsAdapter
        newsAdapter.notifyDataSetChanged()
    }
}

