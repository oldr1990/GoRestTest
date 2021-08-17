package com.github.goresttest.di

import androidx.paging.ExperimentalPagingApi
import com.github.goresttest.constants.GoRestApi.BASE_URL
import com.github.goresttest.di.retrofit.GoRestApi
import com.github.goresttest.repository.DefaultRepository
import com.github.goresttest.repository.RepositoryInterface
import com.github.goresttest.repository.paging.GoRestMediator
import com.github.goresttest.repository.room.GoRestDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {
    @ExperimentalPagingApi
    @Singleton
    @Provides
    fun provideRepository(
        goRestMediator: GoRestMediator,
        goDataBase: GoRestDb
    ): RepositoryInterface = DefaultRepository(goRestMediator, goDataBase)

    @Singleton
    @Provides
    fun provideOkHTTP(): OkHttpClient =
        OkHttpClient()
            .newBuilder()
            .callTimeout(20, TimeUnit.SECONDS)
            .build()

    @Singleton
    @Provides
    fun provideGoRestApi(okHttpClient: OkHttpClient): GoRestApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(GoRestApi::class.java)
}