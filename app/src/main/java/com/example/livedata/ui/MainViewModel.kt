package com.example.livedata.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.livedata.repository.BaeminRepository
import com.example.livedata.repository.model.remote.response.Data
import com.example.livedata.repository.source.remote.BaeminRemoteDataSourceImpl

class MainViewModel : ViewModel() {
    // Repository 객체 생성
    private val baeminRemoteDataSourceImpl = BaeminRemoteDataSourceImpl()

    // Repository에 있는 MutableLiveData를 ViewModel의 LiveData에 넣음
    private val baeminNotice: LiveData<Data>
        get() = baeminRemoteDataSourceImpl._baeminNotice

    fun loadBaeminNotice(page:Int) {
        baeminRemoteDataSourceImpl.loadBaeminNotice(page) // repository에 있는 메소드를 호출함으로써 다음 공지사항을 불러옴
    }

    fun getAll() : LiveData<Data> {
        return baeminNotice
    }
}