package com.example.kotlinmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<News>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.armin,
            R.drawable.eldia,
            R.drawable.eren_jaegar,
            R.drawable.fire,
            R.drawable.floch,
            R.drawable.mikasa,
            R.drawable.paradi,
            R.drawable.reiner_braun
        )

        heading = arrayOf(
            "It was the first time he had ever seen someone cook dinner on an elephant.",
            "His get rich quick scheme was to grow a cactus farm.",
            "The dead trees waited to be ignited by the smallest spark and seek their revenge.",
            "That was how he came to win $1 million.",
            "There are few things better in life than a slice of pie.",
            "It must be easy to commit crimes as a snake because you don't have to worry about leaving fingerprints.",
            "Warm beer on a cold day isn't my idea of fun.",
            "She only paints with bold colors; she does not like pastels."
        )

        newRecyclerView = findViewById(R.id.recyclerview);
        newRecyclerView.layoutManager = LinearLayoutManager(this);
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<News>()
        getUserdata()
    }

    private fun getUserdata() {

        for(i in imageId.indices) {
            val news = News(imageId[i],heading[i])
            newArrayList.add(news)
        }

        newRecyclerView.adapter = MyAdapter(newArrayList)
    }
}