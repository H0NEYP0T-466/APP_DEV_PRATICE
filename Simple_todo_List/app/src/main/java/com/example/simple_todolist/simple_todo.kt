package com.example.simple_todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme

import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

data class SimpleTodoItem(
    val text: String,
    var isChecked: Boolean = false
)

@Composable
fun Todolist() {

    var userInput by remember { mutableStateOf("") }
    val todoItems = remember { mutableStateListOf<SimpleTodoItem>() }

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color.Black)
        ) {
            Text(
                text = "TODO LIST",
                color = Color.White,
                fontSize = 28.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 15.dp)
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 72.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                .fillMaxSize()
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = userInput,
                    onValueChange = { userInput = it },
                    modifier = Modifier.weight(1f),
                    label = { Text("Enter new item") }
                )
                Button(
                    onClick = {
                        if (userInput.isNotBlank()) {
                            todoItems.add(0,SimpleTodoItem(text = userInput))
                            userInput = ""
                        }
                    },
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text("+ List Item")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (todoItems.isEmpty()) {
                Text(
                    "No items yet. Add some!",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 20.dp)
                )
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(todoItems.size) { index ->
                        val item = todoItems[index]
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = item.isChecked,
                                onCheckedChange = { newCheckedState ->
                                    todoItems[index] = item.copy(isChecked = newCheckedState)
                                }
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = item.text
                            )
                        }
                    }
                }
            }
        }
    }
}