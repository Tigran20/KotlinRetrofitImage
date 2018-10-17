package com.alextroy.kotlinphotos.view.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.alextroy.kotlinphotos.R
import com.alextroy.kotlinphotos.api.GalleryApp
import com.alextroy.kotlinphotos.dto.ImagesDto
import com.alextroy.kotlinphotos.dto.ResultDto
import com.alextroy.kotlinphotos.view.adapter.GalleryAdapter
import kotlinx.android.synthetic.main.images_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    companion object {
        private const val KEY = "2adfac9731d6b227157764260c381ad7"
    }

    private lateinit var adapter: GalleryAdapter
    private lateinit var imagesList: List<ImagesDto>

    private val galleryApp by lazy {
        GalleryApp.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.images_list)

        initRecyclerView()
        getData()
    }

    private fun initRecyclerView() {
        imagesList = ArrayList()
        adapter = GalleryAdapter(imagesList,this@MainActivity)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = GridLayoutManager(this, 2)
    }

    private fun getData() {
        galleryApp.getImages(KEY).enqueue(object : Callback<ResultDto> {
            override fun onResponse(call: Call<ResultDto>, response: Response<ResultDto>) {
                adapter.addAll(response.body()!!.results)
            }

            override fun onFailure(call: Call<ResultDto>, t: Throwable) {
            }
        })
    }
}