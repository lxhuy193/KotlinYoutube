package com.example.kotlinyoutube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException
import java.nio.channels.Channel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rcv_main = findViewById<RecyclerView>(R.id.rcv_main)
        rcv_main.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        rcv_main.adapter = MainAdapter()

        fetchJson()
    }

    fun fetchJson(){
        print("Attempting to fetch JSON")

        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback{
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                println(body)

                val gson = GsonBuilder().create()
                val homeFeed = gson.fromJson(body,HomeFeed::class.java)

                runOnUiThread {
                    val rcv_main = findViewById<RecyclerView>(R.id.rcv_main)
                    rcv_main.adapter = MainAdapter(homeFeed)
                }

//                Toast.makeText(this@MainActivity, body, Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed")
//                Toast.makeText(this@MainActivity,"Failed to load", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
//0		{6}
    //id	:	1
    //name	:	Instagram Firebase - Learn How to Create Users, Follow, and Send Push Notifications
    //link	:	https://www.letsbuildthatapp.com/course/instagram-firebase
    //imageUrl	:	https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/04782e30-d72a-4917-9d7a-c862226e0a93
    //channel		{3}
    //  name	:	Lets Build That App
    //  profileimageUrl	:	https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/dda5bc77-327f-4944-8f51-ba4f3651ffdf
    //  numberOfSubscribers	:	100000
    //numberOfViews	:	20000

class HomeFeed (val videos : List<Video>)
class Video (val id : Int, val name: String, val link : String, val imageUrl: String, val numberOfViews : Int, val channel : com.example.kotlinyoutube.Channel)
class Channel (val name : String, val profileimageUrl : String, val numberOfSubscribers : Int)