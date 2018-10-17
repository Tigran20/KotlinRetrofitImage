package com.alextroy.kotlinphotos.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alextroy.kotlinphotos.R
import com.alextroy.kotlinphotos.dto.ImagesDto
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_list_item.view.*

class GalleryAdapter(private var items: List<ImagesDto>, private val context: Context) :
    RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.image_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val images = items[position]
        Picasso.get().load(URL + SIZE + images.posterPath).into(holder.newsImage)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val newsImage = view.image!!
    }

    fun addAll(list: List<ImagesDto>) {
        items = list
        notifyDataSetChanged()
    }

    companion object {
        private const val URL = "https://image.tmdb.org/t/p/"
        private const val SIZE = "w500/"
    }

}