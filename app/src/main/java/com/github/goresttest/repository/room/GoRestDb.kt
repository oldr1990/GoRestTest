package com.github.goresttest.repository.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.goresttest.model.room.PostRoom

@Database(entities = [PostRoom::class], version = 1)
abstract class GoRestDb():RoomDatabase() {
    abstract fun PostRoomDao(): PostRoomDao
}