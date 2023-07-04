package com.example.firebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FoodActivity : AppCompatActivity() {

    private lateinit var newRecyclerview: RecyclerView
    private lateinit var newArrayList : ArrayList<News>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var setsAndReps : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        imageId = arrayOf(
            R.drawable.food1,
            R.drawable.food2,
            R.drawable.food3,
            R.drawable.food4,
            R.drawable.food5,
            R.drawable.food6,
            R.drawable.food7,
        )

        heading = arrayOf(
            "Chicken breast",
            "Egg",
            "Salmon",
            "Buckwheat",
            "Oatmeal",
            "Wheat bread",
            "Banana"
        )
        setsAndReps = arrayOf(
            "100g - 165 calories, Protein 25g, Carbs 0g, Fat 3.6g ",
            "One egg - 72 calories, Protein 6g, Carbs 0.4g, Fat 4.8g",
            "100g - 92 calories, Protein 3.4g, Carbs 20g, Fat 0.6g ",
            "100g - 165 calories, Protein 25g, Carbs 0g, Fat 3.6g ",
            "100g - 71 calories, Protein 2.5g, Carbs 12g, Fat 1.5g ",
            "100g - 267 calories, Protein 11g, Carbs 49g, Fat 3.2g ",
            "100g - 89 calories, Protein 1.1g, Carbs 23g, Fat 0.3g "
        )

        newRecyclerview = findViewById(R.id.foodRecyclerView)
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