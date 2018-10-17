package com.alextroy.kotlinphotos.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GalleryApp {
    private const val BASE_URL = "http://api.themoviedb.org/3/"

    fun create(): GalleryApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(GalleryApi::class.java)
    }
}