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
import androidx.compose.foundation.lazy.LazyColumn

// State management
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.ui.text.input.KeyboardType



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //enableEdgeToEdge()
        setContent {
            //Calculator()
            //greet()
            //counter()
            //LazyItemColumn()
            //Counter2()
            Tip_Calculator()

        }

        }
}


fun calculateSum(x : Double ,y : Double): Double
{
    return x+y
}
fun calculatesub(x : Double ,y : Double): Double
{
    return x-y
}
fun calculatemul(x : Double ,y : Double): Double
{
    return x*y
}
fun calculatediv(x : Double ,y : Double): Double {
    if (y == 0.0) return 0.0
    return x / y
}

@Composable
fun Calculator() {
    var userInput by remember { mutableStateOf("") }
    var userInput2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<Double?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Enter the first number:")
        TextField(
            value = userInput,
            onValueChange = { userInput = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            label = { Text("First Number") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("Enter the second number:")
        TextField(
            value = userInput2,
            onValueChange = { userInput2 = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            label = { Text("Second Number") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            val x = userInput.toDoubleOrNull()
            val y = userInput2.toDoubleOrNull()
            if (x != null && y != null) {
                result = calculateSum(x.toDouble(), y.toDouble())
            }
        }) {
            Text("Calculate Addition")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            val x = userInput.toDoubleOrNull()
            val y = userInput2.toDoubleOrNull()
            if (x != null && y != null) {
                result = calculatesub(x.toDouble(), y.toDouble())
            }
        }) {
            Text("Calculate Subtraction")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            val x = userInput.toDoubleOrNull()
            val y = userInput2.toDoubleOrNull()
            if (x != null && y != null) {
                result = calculatemul(x.toDouble(), y.toDouble())
            }
        }) {
            Text("Calculate Multiplaction")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            val x = userInput.toDoubleOrNull()
            val y = userInput2.toDoubleOrNull()
            if (x != null && y != null) {
                result = calculatediv(x.toDouble(), y.toDouble())
            }
        }) {
            Text("Calculate Division")
        }
        Spacer(modifier = Modifier.height(20.dp))

        if (result != null) {
            Text("The Result of the calculation is = $result", style = MaterialTheme.typography.headlineSmall)
        }
    }
}


