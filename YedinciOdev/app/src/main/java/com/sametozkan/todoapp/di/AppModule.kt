package com.sametozkan.todoapp.di

import android.content.Context
import androidx.room.Room
import com.sametozkan.todoapp.data.datasource.ToDosDataSource
import com.sametozkan.todoapp.data.repository.ToDosRepository
import com.sametozkan.todoapp.room.MyDatabase
import com.sametozkan.todoapp.room.ToDosDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideToDosRepository(toDosDataSource: ToDosDataSource): ToDosRepository {
        return ToDosRepository(toDosDataSource)
    }

    @Provides
    @Singleton
    fun provideToDosDataSource(toDosDao : ToDosDao): ToDosDataSource {
        return ToDosDataSource(toDosDao)
    }

    @Provides
    @Singleton
    fun provideToDosDao(@ApplicationContext appContext: Context) : ToDosDao {
        val myDatabase = Room
            .databaseBuilder(
                context = appContext,
                MyDatabase::class.java,
                "toDos.sqlite")
            .createFromAsset("toDos.sqlite")
            .build()
        return myDatabase.getToDosDao()
    }
}