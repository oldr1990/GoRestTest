package com.github.goresttest.model.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class PostRoom(
    @PrimaryKey val title: String,
    @ColumnInfo(name = "body") val body: String
)
