package com.example.quizz.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz.R
import com.example.quizz.adapter.CategoryAdapter.CategoryViewHolder
import com.example.quizz.fragments.CategoryFragment
import com.example.quizz.model.Quiz
import kotlinx.android.synthetic.main.quiz_category.view.*

class CategoryAdapter(val quizzes: ArrayList<Quiz>) :
    RecyclerView.Adapter<CategoryViewHolder>() {


    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(quizzes: Quiz) {
            itemView.quizTitle.text = quizzes.title
            itemView.quizImage.setImageResource(quizzes.image)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quiz_category,parent,false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val quiz = quizzes[position]
        holder.bind(quiz)

    }

    override fun getItemCount(): Int {
        return quizzes.size
    }
}