package com.sametozkan.todoapp.data.repository

import com.sametozkan.todoapp.data.datasource.ToDosDataSource
import com.sametozkan.todoapp.data.entity.ToDo

class ToDosRepository(var toDosDataSource: ToDosDataSource) {

    suspend fun save( title:String, description:String) = toDosDataSource.save(title, description)

    suspend fun update(id:Int, title:String, description:String) = toDosDataSource.update(id, title, description)

    suspend fun delete(id:Int) = toDosDataSource.delete(id)

    suspend fun getToDos() : List<ToDo> = toDosDataSource.getToDos()

    suspend fun search(word: String) : List<ToDo> = toDosDataSource.search(word)

}