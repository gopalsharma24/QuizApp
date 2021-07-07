package com.example.quizz

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import kotlinx.android.synthetic.main.quiz_mini.view.*

class ViewAdapter(var quizList : ArrayList<QuizzData>):
    RecyclerView.Adapter<ViewAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        fun bind (quiz: QuizzData)
        {
            itemView.quiz_title.text=quiz.title
            itemView.imageView.setImageResource(quiz.image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.quiz_list_view,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val quiz = quizList[position]
        holder.bind(quiz)
    }

    override fun getItemCount(): Int {
        return quizList.size
    }

}