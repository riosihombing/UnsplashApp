package com.rio.unsplashapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rio.unsplashapp.API.InstanceRetrofit
import com.rio.unsplashapp.Model.UnsplashImage
import com.rio.unsplashapp.adapter.RandomImageAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val clientId = "EaAmHZuXIjwViS0VWfLN-S8Vo1M55GgQ3ZWfI5gTNsA"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view_rdm)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val api = InstanceRetrofit.api
        api.getRandomImages(clientId, 1000).enqueue(object : Callback<List<UnsplashImage>> {
            override fun onResponse(call: Call<List<UnsplashImage>>, response: Response<List<UnsplashImage>>) {
                if (response.isSuccessful) {
                    val images = response.body() ?: emptyList()
                    recyclerView.adapter = RandomImageAdapter(images)
                }
            }

            override fun onFailure(call: Call<List<UnsplashImage>>, t: Throwable) {
            }
        })
    }
}
