package com.example.livedata.api

import com.example.livedata.repository.model.remote.response.BaeminData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("contents?typeCode=notice&size=10")
    fun loadNotice(@Query("page") page: String): Call<BaeminData>
}