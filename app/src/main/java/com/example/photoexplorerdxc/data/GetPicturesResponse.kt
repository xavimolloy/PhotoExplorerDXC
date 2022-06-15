package com.example.photoexplorerdxc.data

data class GetPicturesResponse(
    val photos: PicturesMetaData
)

data class PicturesMetaData(
    val page: Int,
    val photo: List<PictureResponse>
)

data class PictureResponse(
    val id: String,
    val author: String,
    val secret: String,
    val server: String,
    val farm: Int,
    val title: String
)
