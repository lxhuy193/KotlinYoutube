package com.example.kotlinyoutube

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CourseDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val rcv_detail = findViewById<RecyclerView>(R.id.rcv_main)
        rcv_detail.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        rcv_detail.adapter = CourseDetailAdapter()

        //intent
        val appBarTitle = intent.getStringExtra("AppbarTitle")
        supportActionBar?.title = appBarTitle
    }
}