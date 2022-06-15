package com.example.photoexplorerdxc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.photoexplorerdxc.R
import com.example.photoexplorerdxc.domain.Foto
import kotlinx.android.synthetic.main.activity_pictures.*
import kotlinx.android.synthetic.main.activity_pictures.picturesRecyclerView
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val SEARCH_DELAY_MS = 200L

class PicturesActivity : AppCompatActivity() {
    private val picturesViewModel: PicturesViewModel by viewModels()
    private val picturesAdapter = PicturesAdapter()

    private var searchJob: Job? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pictures)

      searchBox.addTextChangedListener { editable ->
            searchJob?.cancel()
            searchJob = lifecycleScope.launch {
                delay(SEARCH_DELAY_MS)
                val imagesList = picturesViewModel.fetchImages(editable.toString())
                with(picturesAdapter) {
                    pictures.clear()
                    pictures.addAll(imagesList)
                    notifyDataSetChanged()
                }
            }
        }
        // Set up recycler view
        picturesRecyclerView.adapter = picturesAdapter
        picturesRecyclerView.layoutManager = GridLayoutManager(this, 1)

    }
}