package com.example.firebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import java.lang.Math.ceil
import java.lang.Math.round

class CalculatorActivity : AppCompatActivity() {
    private lateinit var caloriesOutputTV : TextView
    private  lateinit var ageET : EditText
    private  lateinit var weightET : EditText
    private  lateinit var heightET : EditText
    private lateinit var calculateBtn : AppCompatButton
    private lateinit var genderRadioGroup : RadioGroup
    private lateinit var activityRadioGroup : RadioGroup
    private var gender = ""
    private var activity = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        init()
        listeners()
    }

    private fun listeners() {
        calculateBtn.setOnClickListener() {
            val age = ageET.text.toString()
            val height = heightET.text.toString()
            val weight = weightET.text.toString()
            if (age.isEmpty() || height.isEmpty() || weight.isEmpty() || gender.isEmpty() || activity.isEmpty()) {
                Toast.makeText(this,"ALL FIELDS ARE MANDATORY",Toast.LENGTH_SHORT).show()
            } else {
                if ((age.toInt() > 100 || age.toInt() < 5) || (weight.toInt() < 30 || weight.toInt() > 400) || (height.toInt() < 120 || height.toInt() > 250 ) ) {
                    caloriesOutputTV.text = "Your given values are incorrect or out of range"
                    Toast.makeText(this,"INPUTED VALUES ARE INCORRECT",Toast.LENGTH_SHORT).show()
                } else {
                    var bmr = 0.0
                    var caloriesTotal = 0.0

                    if (gender == "Male") {
                        bmr = 88.362 + (13.397 * weight.toInt()) + (4.799 * height.toInt()) - (5.677 * age.toInt())
                    } else {
                        bmr = 447.593 + (9.247 * weight.toInt()) + (3.098 * height.toInt()) - (4.330 * age.toInt())
                    }

                    if (activity == "Little to no exercise") {
                        caloriesTotal = Math.ceil(bmr * 1.2)
                    } else if (activity == "Exercise 1-3 times/week") {
                        caloriesTotal = Math.ceil(bmr * 1.375)
                    } else if (activity == "Exercise 4-5 times/week") {
                        caloriesTotal = Math.ceil(bmr * 1.55)
                    } else if (activity == "Intense exercise 6-7 times/week") {
                        caloriesTotal = Math.ceil(bmr * 1.725)
                    }

                    val midWeightLoss = caloriesTotal - 200
                    val weightLoss = caloriesTotal - 500
                    val extremeWeightLoss = caloriesTotal - 1000
                    caloriesOutputTV.text = "Maintain - $caloriesTotal calories\nMid weight loss - $midWeightLoss calories\nWeight loss - $weightLoss calories\nExtreme weight loss - $extremeWeightLoss calories"


                }
            }
        }

        genderRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = findViewById<RadioButton>(checkedId)
            gender = radioButton.text.toString()
        }

        activityRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = findViewById<RadioButton>(checkedId)
            activity = radioButton.text.toString()
        }

    }

    private fun init() {
        caloriesOutputTV = findViewById(R.id.caloriesOutputTV)
        ageET = findViewById(R.id.ageET)
        weightET = findViewById(R.id.weightET)
        heightET = findViewById(R.id.heightET)
        calculateBtn = findViewById(R.id.calculateBtn)
        genderRadioGroup = findViewById(R.id.genderRadioGroup)
        activityRadioGroup = findViewById(R.id.activityRadioGroup)
    }
}