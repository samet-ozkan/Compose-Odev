package com.sametozkan.todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sametozkan.todoapp.data.entity.ToDo

@Database(entities = [ToDo::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun getToDosDao() : ToDosDao
}