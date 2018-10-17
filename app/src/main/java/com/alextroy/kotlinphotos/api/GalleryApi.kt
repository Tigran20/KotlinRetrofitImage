package com.alextroy.kotlinphotos.api

import com.alextroy.kotlinphotos.dto.ResultDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GalleryApi {
    @GET("movie/popular")
    fun getImages(@Query("api_key") key: String): Call<ResultDto>
}