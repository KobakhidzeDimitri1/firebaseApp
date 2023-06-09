package com.example.firebaseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ProfileActivity : AppCompatActivity() {
    private lateinit var imageView : ImageView
    private lateinit var userNameTV : TextView
    private lateinit var userNameET : EditText
    private lateinit var userUrlET : EditText
    private lateinit var uploadBtn : AppCompatButton
    private lateinit var updatePasswordBtn : AppCompatButton
    private lateinit var closeAppBtn: AppCompatButton
    private lateinit var goToHomeBtn : AppCompatButton

    private val db = Firebase.database.getReference("User")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        init()
        listeners()

        db.child(FirebaseAuth.getInstance().uid!!).addValueEventListener(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val userInfo = snapshot.getValue(User::class.java) ?: return
//                if (userInfo == null) return
                Glide.with(this@ProfileActivity).load(userInfo.url).into(imageView)
                userNameTV.text = userInfo.name
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ProfileActivity, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        updatePasswordBtn.setOnClickListener(){
            startActivity(Intent(this,UpdatePasswordActivity::class.java))
        }
        closeAppBtn.setOnClickListener() {
            finish()
        }



    }

    private fun listeners() {
        uploadBtn.setOnClickListener {
            val name = userNameET.text.toString()
            val url = userUrlET.text.toString()
            val userInfo = User(name, url)
//            Glide.with(this).load(url).into(imageView)
            db.child(FirebaseAuth.getInstance().uid!!).setValue(userInfo)
        }
        goToHomeBtn.setOnClickListener() {
            startActivity(Intent(this,HomeActivity::class.java))
        }
    }

    private fun init(){
        imageView = findViewById(R.id.imageView)
        userNameTV = findViewById(R.id.userNameTV)
        userNameET = findViewById(R.id.userNameET)
        userUrlET = findViewById(R.id.userUrlET)
        uploadBtn = findViewById(R.id.uploadBtn)
        updatePasswordBtn = findViewById(R.id.updatePasswordBtn)
        closeAppBtn = findViewById(R.id.closeAppBtn)
        goToHomeBtn = findViewById(R.id.goToHomeBtn)
    }
}