package com.example.personal_asistant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private var goalsList: ArrayList<GoalDto>): RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.goal_card, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return goalsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = goalsList[position]
        holder.header.text = currentItem.header
        holder.body.text = currentItem.body
        holder.timer.text = currentItem.endDate
    }

    class ViewHolder(itemsView: View): RecyclerView.ViewHolder(itemsView) {
        val header: TextView = itemsView.findViewById(R.id.goal_header)
        val body: TextView = itemsView.findViewById(R.id.goal_body)
        val timer: TextView = itemsView.findViewById(R.id.goal_timer)
    }
}