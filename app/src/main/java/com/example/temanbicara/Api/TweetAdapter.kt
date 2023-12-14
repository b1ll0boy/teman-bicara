package com.example.temanbicara.Api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.temanbicara.R

class TweetAdapter(private val tweets: List<String>) : RecyclerView.Adapter<TweetAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tweet, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tweets[position])
    }

    override fun getItemCount(): Int {
        return tweets.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tweet: String) {
            // Bind tweet data to UI components
            val tweetTextView: TextView = itemView.findViewById(R.id.tweetTextView)
            tweetTextView.text = tweet
        }
    }
}
