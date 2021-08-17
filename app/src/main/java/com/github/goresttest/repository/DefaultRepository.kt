package com.github.goresttest.repository

import androidx.paging.*
import com.github.goresttest.model.room.PostRoom
import com.github.goresttest.repository.paging.GoRestMediator
import com.github.goresttest.repository.room.GoRestDb
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultRepository
    @ExperimentalPagingApi
    @Inject constructor(
        private val mediator: GoRestMediator,
        private val database: GoRestDb,
    ):RepositoryInterface {
    private val databaseDao = database.PostRoomDao()
    @ExperimentalPagingApi
    override suspend fun searchPosts(): Flow<PagingData<PostRoom>> =
        Pager(
            config = PagingConfig(20),
            remoteMediator = mediator
        ){
            databaseDao.getPosts()
        }.flow
}