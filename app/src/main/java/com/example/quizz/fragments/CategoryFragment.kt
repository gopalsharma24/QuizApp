package com.example.quizz.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quizz.R
import com.example.quizz.adapter.CategoryAdapter
import com.example.quizz.model.Quiz
import kotlinx.android.synthetic.main.fragment_category.*


class CategoryFragment : Fragment(R.layout.fragment_category) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val quizItem = arrayListOf<Quiz>(
            Quiz(R.drawable.andstudio, "Android Studio"),
            Quiz(R.drawable.java, "Java Basics"),
            Quiz(R.drawable.kotlin, "Kotlin Fundamentals"),
            Quiz(R.drawable.swift, "Swift Basics"),
            Quiz(R.drawable.linux, "Linux"),
            Quiz(R.drawable.kotlin, "Kotlin Fundamentals"),
            Quiz(R.drawable.java, "Java Basics"),
            Quiz(R.drawable.swift, "Swift Basics"),
            Quiz(R.drawable.linux, "Linux"),
            Quiz(R.drawable.andstudio, "Android Studio"),
            Quiz(R.drawable.kotlin, "Kotlin Fundamentals"),
            Quiz(R.drawable.java, "Java Basics")


        )


        val recyclerAdapter = CategoryAdapter(quizItem)
        categoryView.layoutManager = GridLayoutManager(context, 2)
        categoryView.adapter = recyclerAdapter
    }


}