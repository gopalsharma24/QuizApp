package com.example.quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth

import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_profile.*

class MainActivity2 : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        mAuth = FirebaseAuth.getInstance()
        val currentUser=mAuth.currentUser

        user_name.text=currentUser?.displayName

        var quizList = arrayListOf<QuizzData>(
            QuizzData(R.drawable.andstudio,"Android Studio"),
            QuizzData(R.drawable.java,"Java Basics"),
            QuizzData(R.drawable.kotlin,"Kotlin Fundamentals"),
            QuizzData(R.drawable.swift,"Swift Basics"),
            QuizzData(R.drawable.linux,"Linux"),

        )

        val recyclerAdapter= ViewAdapter(quizList)
        new_quiz_view.adapter = recyclerAdapter

    }
}