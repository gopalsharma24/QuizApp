package com.example.quizz.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz.R
import com.example.quizz.profile.StatAdapter.*
import kotlinx.android.synthetic.main.stat_list.view.*

class StatAdapter(private val AllStats: ArrayList<StatData>) :
    RecyclerView.Adapter<MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(stat: StatData) {
            itemView.stat_txt.text = stat.name
            itemView.stat_image.setImageResource(stat.image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.stat_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val stat = AllStats[position]
        holder.bind(stat)
    }

    override fun getItemCount(): Int {
        return AllStats.size
    }

}