package com.example.photoexplorerdxc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.photoexplorerdxc.R
import com.example.photoexplorerdxc.domain.Foto
import kotlinx.android.synthetic.main.activity_pictures.*

class PicturesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pictures)
        val picturesViewModel: PicturesViewModel by viewModels()

        picturesRecyclerView.adapter = picturesViewModel.picturesAdapter
        picturesRecyclerView.layoutManager = GridLayoutManager(this, 3)
        picturesViewModel.loadPhotos().observe(this,
            Observer<List<Foto>> { list ->
                with(picturesViewModel.picturesAdapter) {
                    pictures.clear()
                    pictures.addAll(list)
                    notifyDataSetChanged()
                }
            })
    }
}