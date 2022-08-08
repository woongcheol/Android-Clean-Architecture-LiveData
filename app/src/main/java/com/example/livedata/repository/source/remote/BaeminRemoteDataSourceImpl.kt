package com.example.livedata.repository.source.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.livedata.api.ApiClient
import com.example.livedata.repository.model.remote.response.BaeminData
import com.example.livedata.repository.model.remote.response.Data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BaeminRemoteDataSourceImpl() : BaeminRemoteDataSource {

    var _baeminNotice = MutableLiveData<Data>()

    // contents - 공지 목록
    override fun loadBaeminNotice(page: Int) {
        val baeminApi = ApiClient.service.loadNotice(page.toString())
        baeminApi.enqueue(object : Callback<BaeminData> {
            override fun onResponse(call: Call<BaeminData>, response: Response<BaeminData>) {
                if (response.isSuccessful) {
                    _baeminNotice.value = response.body()!!.data
                } else {
                    Log.v("로그", "응답 없음")
                }
            }

            override fun onFailure(call: Call<BaeminData>, t: Throwable) {
                Log.v("로그", "통신 실패")
            }
        })
    }
}