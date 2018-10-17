package com.alextroy.kotlinphotos.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ResultDto(
    @SerializedName("results")
    @Expose
    val results: List<ImagesDto>
)

data class ImagesDto(
    @SerializedName("poster_path")
    @Expose
    val posterPath: String
)