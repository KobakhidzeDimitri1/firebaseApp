package com.example.firebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class ExercisesActivity : AppCompatActivity() {

    private lateinit var newRecyclerview: RecyclerView
    private lateinit var newArrayList : ArrayList<News>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var setsAndReps : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercises)

        imageId = arrayOf(
            R.drawable.exercise1,
            R.drawable.exercise2,
            R.drawable.exercise3,
            R.drawable.exercise4,
            R.drawable.exercise5,
            R.drawable.exercise6,
            R.drawable.exercise7,
            R.drawable.exercise8,
            R.drawable.exercise9,
            R.drawable.exercise10,
            R.drawable.exercise11,
            R.drawable.exercise12
        )

        heading = arrayOf(
            "Bench press",
            "Incline dumbbell press",
            "Cable chest raises",
            "Cable lateral raises",
            "Cable triceps pushdowns",
            "Shoulder press",
            "Ez bar skull crashers",
            "Lat pulldowns",
            "T-bar rows",
            "Cable face pulls",
            "Biceps Curls",
            "Scott curls"
        )
        setsAndReps = arrayOf(
            "3 sets of 10-12 repetitions",
            "3 sets of 5-10 repetitions",
            "3 sets of 8-10 repetitions",
            "3 sets of 10-15 repetitions",
            "3 sets of 5-10 repetitions",
            "3 sets of 8-12 repetitions",
            "3 sets of 10-12 repetitions",
            "3 sets of 5-10 repetitions",
            "3 sets of 5-10 repetitions",
            "3 sets of 5-10 repetitions",
            "3 sets of 5-8 repetitions",
            "3 sets of 8-10 repetitions"
        )

        newRecyclerview = findViewById(R.id.recyclerView)
        newRecyclerview.layoutManager = LinearLayoutManager(this)
        newRecyclerview.setHasFixedSize(true)

        newArrayList = arrayListOf<News>()
        getUserData()



    }

    private fun getUserData() {
        for (i in imageId.indices) {
            val news = News(imageId[i],heading[i],setsAndReps[i])
            newArrayList.add(news)
        }

        newRecyclerview.adapter = MyAdapter(newArrayList)
    }



}