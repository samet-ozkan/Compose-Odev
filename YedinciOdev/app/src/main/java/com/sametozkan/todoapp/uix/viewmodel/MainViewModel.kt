package com.sametozkan.todoapp.uix.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sametozkan.todoapp.data.entity.ToDo
import com.sametozkan.todoapp.data.repository.ToDosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var toDosRepository: ToDosRepository) : ViewModel() {
    var toDoList = MutableLiveData<List<ToDo>>()

    init {
        getToDos()
    }

    fun delete(id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            toDosRepository.delete(id)
            getToDos()
        }

    }

    fun getToDos() {
        CoroutineScope(Dispatchers.Main).launch {
            toDoList.value = toDosRepository.getToDos()
        }

    }

    fun search(word: String) {
        CoroutineScope(Dispatchers.Main).launch {
            toDoList.value = toDosRepository.search(word)
        }

    }

}