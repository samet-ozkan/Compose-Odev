package com.sametozkan.todoapp.data.datasource

import com.sametozkan.todoapp.data.entity.ToDo
import com.sametozkan.todoapp.room.ToDosDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDosDataSource(var toDosDao: ToDosDao) {

    suspend fun save( title:String, description:String){
        val newToDo = ToDo(0, title, description)
        toDosDao.save(newToDo)
    }

    suspend fun update(id:Int, title:String, description:String){
        val toDo = ToDo(id, title, description)
        toDosDao.update(toDo)
    }

    suspend fun delete(id:Int){
        toDosDao.delete(id)
    }

    suspend fun getToDos() : List<ToDo> = withContext(Dispatchers.IO){

        return@withContext toDosDao.getToDos()
    }

    suspend fun search(word: String) : List<ToDo> = withContext(Dispatchers.IO) {
        val toDoList = toDosDao.search(word)

        if (word != "") {
            val filteredList = toDoList.filter { it.title.contains(word, ignoreCase = true) }
            return@withContext filteredList
        }

        return@withContext toDoList
    }

}