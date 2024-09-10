package com.sametozkan.todoapp.uix.viewmodel

import androidx.lifecycle.ViewModel
import com.sametozkan.todoapp.data.repository.ToDosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoDetailViewModel @Inject constructor(var toDosRepository: ToDosRepository) : ViewModel() {

    fun update(id:Int, title:String, description:String){
        CoroutineScope(Dispatchers.Main).launch {
            toDosRepository.update(id, title, description)
        }

    }
}