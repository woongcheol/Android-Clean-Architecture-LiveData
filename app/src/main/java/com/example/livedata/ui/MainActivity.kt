package com.example.livedata.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.livedata.R
import com.example.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var noticeAdapter: NoticeAdapter
    private val model: MainViewModel by viewModels()
    private var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.rvBaeminNotice.apply {
            binding.rvBaeminNotice.layoutManager = LinearLayoutManager(context)
            noticeAdapter = NoticeAdapter()
            binding.rvBaeminNotice.adapter = noticeAdapter
        }
        model.loadBaeminNotice(page)

        // notice에 공지사항이 들어있음
        model.getAll().observe(this, Observer { notice ->
            noticeAdapter.setList(notice.content)
            noticeAdapter.notifyDataSetChanged()
        })

        // 버튼을 누를 때마다 ViewModel의 loadBaeminNotice가 호출
        binding.btnLoadNextPage.setOnClickListener {
            model.loadBaeminNotice(++page)
        }
    }
}