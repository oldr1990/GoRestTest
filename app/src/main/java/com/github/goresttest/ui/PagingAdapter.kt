package com.github.goresttest.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.github.goresttest.R
import com.github.goresttest.model.room.PostRoom

class PagingAdapter() : PagingDataAdapter<PostRoom, GoRestViewHolder>(GoRestDifferentiator) {
    override fun onBindViewHolder(holder: GoRestViewHolder, position: Int) {
        val item = getItem(position) ?: PostRoom("", "")
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoRestViewHolder =
GoRestViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false))

    object GoRestDifferentiator : DiffUtil.ItemCallback<PostRoom>() {
        override fun areItemsTheSame(
            oldItem: PostRoom,
            newItem: PostRoom
        ): Boolean = oldItem.title == newItem.title

        override fun areContentsTheSame(
            oldItem: PostRoom,
            newItem: PostRoom
        ): Boolean = oldItem == newItem
    }
}