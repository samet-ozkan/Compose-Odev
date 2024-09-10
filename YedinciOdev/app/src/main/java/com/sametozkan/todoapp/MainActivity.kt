package com.sametozkan.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sametozkan.todoapp.ui.theme.ToDoAppTheme
import com.sametozkan.todoapp.uix.view.MyNavigation
import com.sametozkan.todoapp.uix.viewmodel.AddToDoViewModel
import com.sametozkan.todoapp.uix.viewmodel.MainViewModel
import com.sametozkan.todoapp.uix.viewmodel.ToDoDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val mainViewModel : MainViewModel by viewModels()
    val addToDoViewModel : AddToDoViewModel by viewModels()
    val toDoDetailViewModel : ToDoDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoAppTheme {
                MyNavigation(
                    mainViewModel = mainViewModel,
                    addToDoViewModel = addToDoViewModel,
                    toDoDetailViewModel = toDoDetailViewModel
                )
            }
        }
    }
}