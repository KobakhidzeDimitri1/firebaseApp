package com.example.firebaseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class HomeActivity : AppCompatActivity() {
    private lateinit var calculatorActivityBtn: AppCompatButton
    private lateinit var exercisesActivityBtn: AppCompatButton
    private lateinit var foodActivityBtn : AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        init()
        listeners()
    }

    private fun listeners() {
        calculatorActivityBtn.setOnClickListener() {
            startActivity(Intent(this,CalculatorActivity::class.java))
        }
        exercisesActivityBtn.setOnClickListener() {
            startActivity(Intent(this,ExercisesActivity::class.java))
        }
        foodActivityBtn.setOnClickListener() {
            startActivity(Intent(this,FoodActivity::class.java))
        }

    }

    private fun init() {
        calculatorActivityBtn = findViewById(R.id.caloriesCalcBtn)
        exercisesActivityBtn = findViewById(R.id.exercisesBtn)
        foodActivityBtn = findViewById(R.id.foodBtn)
    }
}