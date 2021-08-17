package com.github.goresttest.repository.room

import androidx.room.Dao
import androidx.room.Query
import androidx.paging.DataSource
import androidx.paging.PagingSource
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.github.goresttest.model.room.PostRoom

@Dao
interface PostRoomDao {
    @Query("SELECT * FROM posts")
    fun getPosts(): PagingSource<Int,PostRoom>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToPostTable(listToInsert: List<PostRoom>)
}