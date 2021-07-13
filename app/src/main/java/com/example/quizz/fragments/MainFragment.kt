package com.example.quizz.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.SearchView
import com.example.quizz.DetailActivity
import com.example.quizz.R
import com.example.quizz.adapter.ViewAdapter
import com.example.quizz.databinding.ActivityMain2Binding
import com.example.quizz.model.QuizzData
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.collections.contains as c


class MainFragment : Fragment(R.layout.fragment_main), ViewAdapter.OnItemClick {
    private lateinit var mAuth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser

        user_name.text = "Hi, " + currentUser?.displayName

        var quizList = arrayListOf<QuizzData>(
            QuizzData(R.drawable.andstudio, "Android Studio"),
            QuizzData(R.drawable.java, "Java Basics"),
            QuizzData(R.drawable.kotlin, "Kotlin Fundamentals"),
            QuizzData(R.drawable.swift, "Swift Basics"),
            QuizzData(R.drawable.linux, "Linux"),

            )

        val recyclerAdapter = ViewAdapter(quizList, this@MainFragment)
        new_quiz_view.adapter = recyclerAdapter

        textViewAll.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameView, CategoryFragment())
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }


    }

    override fun onClick(position: Int) {
        val intent = Intent(context, DetailActivity::class.java)
        startActivity(intent)

    }
}

