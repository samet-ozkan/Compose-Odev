package com.sametozkan.todoapp.uix.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.gson.Gson
import com.sametozkan.todoapp.R
import com.sametozkan.todoapp.data.entity.ToDo
import com.sametozkan.todoapp.uix.viewmodel.MainViewModel
import kotlinx.coroutines.launch

@Composable
fun MainPage(
    navController: NavController,
    mainViewModel: MainViewModel,
) {
    val isSearching = remember { mutableStateOf(false) }
    val tf = remember { mutableStateOf("") }
    val toDoList by mainViewModel.toDoList.observeAsState(listOf())
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = true) {
        mainViewModel.getToDos()
    }

    MainScreen(
        toDoList = toDoList,
        navController = navController,
        mainViewModel = mainViewModel,
        isSearching = isSearching,
        tf = tf,
        snackbarHostState = snackbarHostState
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddToDoPageTopBar(
    isSearching: MutableState<Boolean>,
    tf: MutableState<String>,
    mainViewModel: MainViewModel
) {
    TopAppBar(
        title = {
            if (isSearching.value) {
                SearchTextField(tf = tf, mainViewModel = mainViewModel)
            } else {
                Text(text = "ToDos", color = MaterialTheme.colorScheme.onPrimary)
            }
        },
        actions = {
            SearchActionButton(isSearching = isSearching, tf = tf, mainPageViewModel = mainViewModel)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(
    tf: MutableState<String>,
    mainViewModel: MainViewModel
) {
    TextField(
        value = tf.value,
        onValueChange = {
            tf.value = it
            mainViewModel.search(it)
        },
        label = { Text(text = "Search") },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.onSurface,
            focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedLabelColor = MaterialTheme.colorScheme.onSurface,
            focusedTextColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedTextColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@Composable
fun SearchActionButton(
    isSearching: MutableState<Boolean>,
    tf: MutableState<String>,
    mainPageViewModel: MainViewModel
) {
    IconButton(onClick = {
        isSearching.value = !isSearching.value
        if (!isSearching.value) {
            tf.value = ""
            mainPageViewModel.getToDos()
        }
    }) {
        Icon(
            painter = painterResource(
                id = if (isSearching.value) R.drawable.baseline_close_24 else R.drawable.baseline_search_24
            ),
            contentDescription = ""
        )
    }
}

@Composable
fun ToDoCard(
    toDo: ToDo,
    navController: NavController,
    mainViewModel: MainViewModel,
    snackbarHostState: SnackbarHostState
) {
    val scope = rememberCoroutineScope()
    Card(
        modifier = Modifier
            .padding(vertical = 5.dp, horizontal = 15.dp)
            .clickable {
                val toDoJson = Gson().toJson(toDo)
                navController.navigate("toDoDetailPage/$toDoJson")
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = toDo.title, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = toDo.description, fontSize = 20.sp)
            }

            IconButton(onClick = {
                scope.launch {
                    val sbResult = snackbarHostState.showSnackbar(
                        message = "${toDo.title} silinsin mi?",
                        actionLabel = "Evet"
                    )
                    if (sbResult == SnackbarResult.ActionPerformed) {
                        mainViewModel.delete(toDo.id)
                    }
                }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_close_24),
                    contentDescription = "",
                    tint = Color.Gray
                )
            }
        }
    }
}

@Composable
fun ToDoList(
    toDoList: List<ToDo>,
    navController: NavController,
    mainViewModel: MainViewModel,
    snackbarHostState: SnackbarHostState
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        items(toDoList.size) { index ->
            val toDo = toDoList[index]
            ToDoCard(
                toDo = toDo,
                navController = navController,
                mainViewModel = mainViewModel,
                snackbarHostState = snackbarHostState
            )
        }
    }
}

@Composable
fun MainScreen(
    toDoList: List<ToDo>,
    navController: NavController,
    mainViewModel: MainViewModel,
    isSearching: MutableState<Boolean>,
    tf: MutableState<String>,
    snackbarHostState: SnackbarHostState
) {
    Scaffold(
        topBar = { AddToDoPageTopBar(isSearching = isSearching, tf = tf, mainViewModel = mainViewModel) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("addToDoPage") },
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_add_24),
                        contentDescription = ""
                    )
                }
            )
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)) {
            ToDoList(
                toDoList = toDoList,
                navController = navController,
                mainViewModel = mainViewModel,
                snackbarHostState = snackbarHostState
            )
        }
    }
}
