package com.example.firebaseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.EmailAuthProvider


class UpdatePasswordActivity : AppCompatActivity() {

    private val currentUser = FirebaseAuth.getInstance().currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_password)


        val updatePasswordBtn = findViewById<AppCompatButton>(R.id.updatePasswordBtn)

        updatePasswordBtn.setOnClickListener() {
            val newPassword = findViewById<EditText>(R.id.newPasswordET).text.toString()
            val repeatNewPassword = findViewById<EditText>(R.id.repeatNewPasswordET).text.toString()
            if(newPassword == repeatNewPassword){

                currentUser?.updatePassword(newPassword)?.addOnCompleteListener(){
                    if(it.isComplete){
                        Toast.makeText(this, "Succesfuly changed password", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,LoginActivity::class.java))
                        finish()
                    }else{
                        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }
}