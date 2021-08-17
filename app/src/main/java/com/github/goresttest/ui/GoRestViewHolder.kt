package com.github.goresttest.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.goresttest.R
import com.github.goresttest.model.room.PostRoom

class GoRestViewHolder(view: View,): RecyclerView.ViewHolder(view) {
    fun bind(item: PostRoom){
            val titleView =itemView.findViewById<TextView>(R.id.title)
            val bodyView =itemView.findViewById<TextView>(R.id.body)
            titleView.text = item.title
            bodyView.text = item.body
    }
}