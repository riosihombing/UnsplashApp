package com.rio.unsplashapp.Model

data class UnsplashImage(
    val id: String,
    val urls: Urls
) {
    data class Urls(
        val regular: String
    )
}
