package com.example.kotlinyoutube

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MainAdapter (val homeFeed : HomeFeed) : RecyclerView.Adapter<MainAdapter.VH>() {


    inner class VH (view : View, var video: Video? = null) : RecyclerView.ViewHolder (view){
        val ivItemMainThumbnail = view.findViewById<ImageView>(R.id.iv_item_main_thumbnail)
        val ivItemMainChannel = view.findViewById<ImageView>(R.id.iv_item_main_channel)
        val tvItemMainTitle = view.findViewById<TextView>(R.id.tv_item_main_title)
        val tvItemMainChannel = view.findViewById<TextView>(R.id.tv_item_main_channel)

        init {
            view.setOnClickListener{
                val intent = Intent(view.context, CourseDetailActivity::class.java)
                intent.putExtra("AppbarTitle", video?.name)
                view.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.rcv_item_main, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.tvItemMainTitle.text = homeFeed.videos[position].name
        holder.tvItemMainChannel.text = homeFeed.videos[position].channel.name

        Picasso.get().load(homeFeed.videos[position].imageUrl).into(holder.ivItemMainThumbnail)
        Picasso.get().load(homeFeed.videos[position].channel.profileimageUrl).into(holder.ivItemMainChannel)

        //VH
        holder.video = homeFeed.videos[position]
    }

    override fun getItemCount(): Int {
        return homeFeed.videos.size
    }
}