package com.example.livedata.repository.model.remote.response

import com.google.gson.annotations.SerializedName

data class BaeminData(val data: Data)

data class Data(val content: ArrayList<Content>)

data class Content(
    @SerializedName("title")
    val title: String,
    @SerializedName("created")
    val date: String
)