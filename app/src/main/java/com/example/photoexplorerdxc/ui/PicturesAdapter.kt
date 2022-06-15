package com.example.photoexplorerdxc.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.photoexplorerdxc.R
import com.example.photoexplorerdxc.domain.Foto
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.imagen_layout.view.*

class PicturesAdapter(val pictures: MutableList<Foto> = mutableListOf()) : RecyclerView.Adapter<PicturesAdapter.PhotosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        return PhotosViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.imagen_layout,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = pictures.size

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.bind(pictures[position])
    }

    inner class PhotosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(photo: Foto) {
            Picasso.get().
            load(photo.url)
                .resize(IMAGE_SIDE_PX, IMAGE_SIDE_PX)
                .centerCrop()
                .into(itemView.imageView)
        }
    }
}

const val IMAGE_SIDE_PX = 400
