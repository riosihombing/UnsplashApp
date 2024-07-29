package com.rio.unsplashapp.API

import com.rio.unsplashapp.Model.UnsplashImage
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashApi {
    @GET("photos")
    fun getRandomImages(@Query("client_id") clientId: String, @Query("per_page") perPage: Int): Call<List<UnsplashImage>>
}
