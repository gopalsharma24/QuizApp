package com.example.quizz.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz.R
import com.example.quizz.model.QuizzData
import kotlinx.android.synthetic.main.quiz_mini.view.*

class ViewAdapter(var quizList: ArrayList<QuizzData>, val listener: OnItemClick) :
    RecyclerView.Adapter<ViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }

        fun bind(quiz: QuizzData) {
            itemView.quiz_title.text = quiz.title
            itemView.imageView.setImageResource(quiz.image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quiz_list_view,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val quiz = quizList[position]
        holder.bind(quiz)
    }

    override fun getItemCount(): Int {
        return quizList.size
    }

    interface OnItemClick {
        fun onClick(position: Int)
    }

}

