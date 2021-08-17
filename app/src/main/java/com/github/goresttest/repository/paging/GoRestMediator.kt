package com.github.goresttest.repository.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.github.goresttest.di.retrofit.GoRestApi
import com.github.goresttest.model.mappers.NetworkToRoomMapper
import com.github.goresttest.model.room.PostRoom
import com.github.goresttest.repository.room.GoRestDb
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@ExperimentalPagingApi
class GoRestMediator
@Inject constructor(
    private val database: GoRestDb,
    private val networkApi: GoRestApi,
    private val networkMapper: NetworkToRoomMapper
) : RemoteMediator<Int, PostRoom>() {
    private val databaseDao = database.PostRoomDao()
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PostRoom>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> null
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = true
                        )
                    state.anchorPosition
                }
            }

            val response = networkApi.getPosts(loadKey)
            if (response.body() != null) {
                databaseDao.insertToPostTable(response.body()!!.data.map {
                    networkMapper.mapFromEntity(it)
                })
            } else MediatorResult.Error(Throwable(response.errorBody().toString()))

            MediatorResult.Success(
                endOfPaginationReached = response.body()?.meta?.pagination?.pages == response.body()?.meta?.pagination?.page
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }

}