package com.example.livedata.repository.source.remote

import com.example.livedata.api.ApiInterface
import com.example.livedata.repository.model.remote.response.Data

interface BaeminRemoteDataSource {
    // contents - 공지 목록
    fun loadBaeminNotice(page:Int)
}