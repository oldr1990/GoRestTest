package com.github.goresttest.di.retrofit

import com.github.goresttest.model.retrofit.PostsDataFromNetwork
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GoRestApi {
    @GET("public-api/posts")
    suspend fun getPosts(
        @Query("page") page: Int?
    ):Response<PostsDataFromNetwork>
}