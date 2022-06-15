package com.example.photoexplorerdxc.ui

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.ViewModel
import com.example.photoexplorerdxc.domain.Foto
import com.example.photoexplorerdxc.services.WebClient

class PicturesViewModel : ViewModel(), Observable {

    suspend fun fetchImages(searchTerm: String): List<Foto> {


        val searchResponse = WebClient.client.fetchImages(searchTerm)


        return searchResponse.photos.photo.map { photo ->
            Foto(
                id = photo.id,
                url = "https://farm${photo.farm}.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}.jpg",
                title = photo.title,
                owner = photo.owner
            )

        }

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}
