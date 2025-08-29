package com.example.day2

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
// Layout and UI
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button

// Alignment and Modifiers
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

// State management
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Arrangement


@Composable
fun Counter2()
{
    Column (modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.Center){
    var count by remember { mutableStateOf(0) }
        Text("The Number is $count")
        Spacer(modifier = Modifier.height(50.dp))
    Button(onClick = { count++ }) { Text("Click to Increase the Number") }
    }
}