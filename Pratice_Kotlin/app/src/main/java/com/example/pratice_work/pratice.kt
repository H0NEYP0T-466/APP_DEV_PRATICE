package com.example.pratice_work

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.foundation.lazy.items

@Composable
fun Toggle_button()
{
    var checked by remember { mutableStateOf(false) }
    Column (modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.Center){
    Text(text="$checked")

    Button(onClick = {
        checked = !checked
    }) {
        Text(text="❤\uFE0F Liked")
    }
    }
    Button(onClick = {}) { }
}



@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SimpleTopAppBar() {
    TopAppBar(
        title = { Text("My App") }
    )
}


@Composable
 fun WeightExample() {
        Row(modifier = Modifier.fillMaxWidth()) {
                 // This Box takes up 1/3 of the available width
                 Box(
                             modifier = Modifier
                                 .height(50.dp)
                                 .weight(1f) // Takes 1 part of the space
                     .background(Color.Red)
                 )
                 // This Box takes up 2/3 of the available width
                 Box(
                             modifier = Modifier
                                 .height(50.dp)
                                 .weight(2f) // Takes 2 parts of the
                                 .background(Color.Blue)
                 )
             }
     }

@Composable
fun SimpleLazyColumn() {
    val fruits = listOf("Apple", "Banana", "Cherry")

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn() {
            items(fruits) { fruit ->
                Text(text = fruit)
            }
        }
    }
}