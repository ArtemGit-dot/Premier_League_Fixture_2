package com.example.premierleaguefixture.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.premierleaguefixture.R
import com.example.premierleaguefixture.model.data.MatchDetails

class MatchAdapter(val listener: Listener): RecyclerView.Adapter<MatchAdapter.MatchHolder>() {
    private var list: List<MatchDetails> = emptyList()

    fun setItem(newList: List<MatchDetails>){
        list = newList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_design, parent, false)
        return MatchHolder(view)
    }

    override fun onBindViewHolder(holder: MatchHolder, position: Int) {

        holder.item1.text = "Номер матча: ${list[position].matchNumber.toString()}"
        holder.item2.text = "Дата: ${list[position].dateUtc}"
        holder.item2.setOnClickListener{
listener.onClick(position)
        }
    }

    interface Listener{
        fun onClick(position: Int)
    }

    override fun getItemCount(): Int = list.size

    class MatchHolder(item: View): RecyclerView.ViewHolder(item) {
        val item1: TextView = itemView.findViewById(R.id.item1)
        val item2: TextView = itemView.findViewById(R.id.item2)


    }
}