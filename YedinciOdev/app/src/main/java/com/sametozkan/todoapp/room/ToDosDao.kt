package com.sametozkan.todoapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sametozkan.todoapp.data.entity.ToDo

@Dao
interface ToDosDao {
@Query("SELECT * FROM toDos")
suspend fun getToDos() : List<ToDo>

    @Query("SELECT * FROM toDos WHERE title like '%' || :word || '%'")
    suspend fun search(word:String) : List<ToDo>

    @Insert
    suspend fun save(toDo: ToDo)

    @Update
    suspend fun update(toDo: ToDo)

    @Query("DELETE FROM toDos WHERE id=:id")
    suspend fun delete(id:Int)

}