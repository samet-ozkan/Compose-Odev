package com.sametozkan.todoapp.uix.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.sametozkan.todoapp.data.entity.ToDo
import com.sametozkan.todoapp.uix.viewmodel.AddToDoViewModel
import com.sametozkan.todoapp.uix.viewmodel.MainViewModel
import com.sametozkan.todoapp.uix.viewmodel.ToDoDetailViewModel

@Composable
fun MyNavigation(mainViewModel: MainViewModel, addToDoViewModel: AddToDoViewModel, toDoDetailViewModel: ToDoDetailViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "mainPage"){

        composable("mainPage"){
            MainPage(navController, mainViewModel)
        }

        composable("addToDoPage"){
            AddToDoPage(addToDoViewModel)
        }

        composable(
            "toDoDetailPage/{toDo}",
            arguments = listOf(
                navArgument("toDo"){
                    type = NavType.StringType
                }
            )
        ){
            val json = it.arguments?.getString("toDo")
            val toDo = Gson().fromJson(json, ToDo::class.java)
            ToDoDetailPage(toDo = toDo, toDoDetailViewModel = toDoDetailViewModel)
        }

    }
}