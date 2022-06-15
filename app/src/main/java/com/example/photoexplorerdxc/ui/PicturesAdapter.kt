package com.example.photoexplorerdxc.ui

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.photoexplorerdxc.R
import com.example.photoexplorerdxc.domain.Foto
import com.example.photoexplorerdxc.interfaces.CellClickListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.imagen_layout.view.*
import kotlin.math.log


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
    var navController: NavController? = null

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val item = pictures[position]

        holder.bind(item)

        holder.itemView.setOnClickListener(View.OnClickListener {

            //navController = Navigation.findNavController(holder.itemView)
            //navController!!.navigate(R.id.FirstFragment)
            Log.d("TAG", "working")
        })
    }

    inner class PhotosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(foto: Foto) {
            Picasso.get().
            load(foto.url)
                .resize(IMAGE_SIDE_PX, IMAGE_SIDE_PX)
                .centerCrop()
                .into(itemView.imageView)
            itemView.titleTextView.text = foto.title
            itemView.authorTextView.text = foto.owner
        }
    }
}


const val IMAGE_SIDE_PX = 400
