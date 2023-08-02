package com.example.volley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Health News"

        val news = mutableListOf<News>()

        val model = ViewModelProvider(this)[NewsViewModel::class.java]
        model.getNews().observe(this){newsSnapshot->
            news.clear()
            news.addAll(newsSnapshot)
        }

        //loadStringRequest()
        //loadJsonRequest()
        //createNewsList()
    }

    private fun loadStringRequest(){
//        // Instantiate the RequestQueue.
//        val queue = Volley.newRequestQueue(this)
//        val url = "https://meme-api.com/gimme"
//
//        // Request a string response from the provided URL.
//        val stringRequest = StringRequest(
//            Request.Method.GET, url, { response ->
//                // request successfully
//                Log.d("success request", response.substring(0,500))
//            },
//            {
//                // request failed
//                Log.d("success request", it.localizedMessage)
//            }
//        )
//
//        // Add the request to the RequestQueue.
//        queue.add(stringRequest)
    }

    private fun loadJsonRequest(){
        // Instantiate the RequestQueue.
//        val queue = Volley.newRequestQueue(this)
//        val memeUrl = "https://meme-api.com/gimme"
//
//        // Request a json response from the provided URL.
//        val jsonObjectRequest = JsonObjectRequest(
//            Request.Method.GET, memeUrl,null,
//            { response ->
//                // request successfully
//                val urlJson = response.getString("url")
//
//                val imageView = binding.memeIv
//                Glide.with(this)
//                    .load(urlJson)
//                    .into(imageView)
//            },
//            {
//                // request failed
//                Log.d("failed request", it.localizedMessage)
//            })
//
//        // Add the request to the RequestQueue.
//        queue.add(jsonObjectRequest)
    }

    private fun createNewsList(){

    }

    fun shareMeme(){

    }

    fun nextMeme(){

    }
}