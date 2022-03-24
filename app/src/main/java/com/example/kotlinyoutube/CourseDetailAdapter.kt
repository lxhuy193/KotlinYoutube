package com.example.kotlinyoutube

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CourseDetailAdapter : RecyclerView.Adapter<CourseDetailAdapter.VH>() {
    inner class VH (view : View) : RecyclerView.ViewHolder (view){
        val ivItemDetail = view.findViewById<ImageView>(R.id.iv_item_detail)
        val tvItemDetailTitle = view.findViewById<TextView>(R.id.tv_item_detail_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.rcv_item_detail, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

    }

    override fun getItemCount(): Int {
        return 6
    }

}