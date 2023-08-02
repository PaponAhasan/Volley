package com.example.volley

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest

class NewsViewModel(application: Application) : AndroidViewModel(application){

    private val newsLiveData: MutableLiveData<MutableList<News>> = MutableLiveData()

    init {
        newsLiveData.value = createNewsList()
    }

    fun getNews() : LiveData<MutableList<News>> {
        return newsLiveData
    }

    private fun createNewsList(): MutableList<News> {

        val newsApiUrl = "https://saurav.tech/NewsAPI/top-headlines/category/health/in.json"

        val newsArray = mutableListOf<News>()

        // Request a json response from the provided URL.
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, newsApiUrl, null,
            { response ->
                // request successfully
                //newsArray = mutableListOf()
                val newsJsonArray = response.getJSONArray("articles")

                for (i in 0 until newsJsonArray.length()) {
                    val newsDataObject = newsJsonArray.getJSONObject(i)
                    val newsData = News(
                        newsDataObject.getString("author"),
                        newsDataObject.getString("title"),
                        newsDataObject.getString("description"),
                        newsDataObject.getString("url"),
                        newsDataObject.getString("urlToImage"),
                        newsDataObject.getString("publishedAt"),
                        newsDataObject.getString("content")
                    )
                    Log.d("TAG", newsData.author)
                    newsArray.add(newsData)
                }
            },
            {
                // request failed
               Log.d("failed request", it.localizedMessage)
            })

        // Add the request to the RequestQueue.
        NewsSingleton.getInstance(getApplication()).addToRequestQueue(jsonObjectRequest)

        return newsArray
    }
}