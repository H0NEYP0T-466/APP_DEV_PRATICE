package com.example.day2
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.day2.ui.theme.Day2Theme
// Layout and UI
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme

// Alignment and Modifiers
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

// State management
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items



@Composable
fun counter()
{

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var counter by remember { mutableStateOf(0) }


    Text(text="$counter")

        Spacer(modifier = Modifier.height(50.dp))
     Button(onClick = { counter++ }) {
        Text(text = "Click me!")
    }

}
}


@Composable
fun LazyItemColumn() {
    val arr = mutableListOf<Int>()
    for(i in 0..1000)
    {
        arr.add(i)
    }

    LazyColumn {
        items(arr) { item ->
            Text(
                text = "Item $item",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
