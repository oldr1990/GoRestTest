package com.github.goresttest.di

import android.content.Context
import androidx.room.Room
import com.github.goresttest.repository.room.GoRestDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Singleton
    @Provides
    fun provideGoRestDb(@ApplicationContext context: Context):GoRestDb =
        Room.databaseBuilder(context,
            GoRestDb::class.java,
        "go_rest_db").build()
}