package com.example.photoexplorerdxc.services

import com.example.photoexplorerdxc.data.GetPicturesResponse
import retrofit2.http.GET

interface ApiService {
    @GET("?method=flickr.photos.search&format=json&nojsoncallback=1&text=dogs&api_key=9970ff1feca9d80afcdd4f10f015edca")
    suspend fun fetchImages(): GetPicturesResponse
}
