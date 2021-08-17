package com.github.goresttest.repository

import androidx.paging.PagingData
import com.github.goresttest.model.room.PostRoom
import kotlinx.coroutines.flow.Flow

interface RepositoryInterface {
    suspend fun searchPosts(): Flow<PagingData<PostRoom>>
}