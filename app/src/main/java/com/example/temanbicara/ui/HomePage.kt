package com.example.temanbicara.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.temanbicara.Api.TweetAdapter
import com.example.temanbicara.R
import org.json.JSONObject

class HomePage : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var tweetAdapter: TweetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        tweetAdapter = TweetAdapter(listOf()) // Initial empty list of tweets
        recyclerView.adapter = tweetAdapter

        fetchTweets()
    }

    private fun fetchTweets() {
        val keyword = "mental health"
        val url = "https://api.twitter.com/2/tweets/search/recent?query=${keyword}"

        val request = object : JsonObjectRequest(Method.GET, url, null,
            Response.Listener { response ->
                val tweets = parseTweets(response)
                updateUI(tweets)
            },
            Response.ErrorListener { error ->
                Log.e("TwitterRequest", "Error: $error")
            }) {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Authorization"] = "AAAAAAAAAAAAAAAAAAAAAP8PqwEAAAAAElNRn1kyJ47oWIzIqeC%2FHcq2N%2Bs%3DCJG0P7M7CqS2obuVFju0PKWUmNcI1gAoPU7XRUBVHejymSfBl3"
                return headers
            }
        }

        val queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(request)
    }

    private fun parseTweets(response: JSONObject): List<String> {
        val tweets: MutableList<String> = mutableListOf()
        val dataArray = response.getJSONArray("data")

        for (i in 0 until dataArray.length()) {
            val tweet = dataArray.getJSONObject(i)
            val text = tweet.getString("text")
            tweets.add(text)
        }

        return tweets
    }


    private fun updateUI(tweets: List<String>) {
        tweetAdapter = TweetAdapter(tweets)
        recyclerView.adapter = tweetAdapter
        tweetAdapter.notifyDataSetChanged()
    }
}

