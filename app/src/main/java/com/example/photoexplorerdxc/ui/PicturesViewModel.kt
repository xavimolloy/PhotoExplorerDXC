package com.example.photoexplorerdxc.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.photoexplorerdxc.domain.Foto
import com.example.photoexplorerdxc.services.WebClient
import kotlinx.coroutines.launch

class PicturesViewModel : ViewModel() {
    private val mutablePicturesListLiveData = MutableLiveData<List<Foto>>()
    private val picturesListLiveData: LiveData<List<Foto>> = mutablePicturesListLiveData

    var picturesAdapter = PicturesAdapter()

    fun loadPhotos(): LiveData<List<Foto>> {
        viewModelScope.launch {

            val searchResponse = WebClient.client.fetchImages()
            val photosList = searchResponse.photos.photo.map { photo ->
                Foto(
                    id = photo.id,
                    url = "https://farm${photo.farm}.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}.jpg",
                    title = photo.title

                )
            }
            mutablePicturesListLiveData.postValue(photosList)
        }
        return picturesListLiveData
    }
}
