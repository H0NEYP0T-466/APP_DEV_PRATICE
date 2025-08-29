package com.example.day2

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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp




@Composable
fun Tip_Calculator() {

    var userAmount by remember { mutableStateOf("") }
    var tip by remember { mutableStateOf("") }
    var people by remember { mutableStateOf("") }
    var calculatedTotalAmount by remember { mutableStateOf(0.0) }
    var amountPerPerson by remember { mutableStateOf(0.0) }

    Box(modifier = Modifier.fillMaxSize())
    {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color.Black)
        ) {

            Text(
                text = "TIP CALCULATOR",
                color = Color.White,
                fontSize = 28.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 15.dp)
            )
        }
        Column (modifier = Modifier.fillMaxWidth().offset(y = 60.dp).offset(x = 20.dp))
        {
            Text(
                text = "Enter the Total bill Amount:",
                fontSize = 18.sp,

            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = userAmount,
                onValueChange = { userAmount = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text("Total Bill Amount", fontSize = 18.sp,) },

            )
            Spacer(modifier = Modifier.height(20.dp))
            Text("The Total Bill is: $userAmount", fontSize = 18.sp)

        }

        Column (modifier = Modifier.fillMaxWidth().offset(y = 220.dp).offset(x = 20.dp))
        {
            Text(
                text = "Enter the Tip Amount :",
                fontSize = 18.sp,
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = tip,
                onValueChange = { tip = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text("Tip Amount ", fontSize = 18.sp) },

                )
            Spacer(modifier = Modifier.height(20.dp))
            Text("The Tip Amount is: $tip", fontSize = 18.sp)

        }


        Column (modifier = Modifier.fillMaxWidth().offset(y = 380.dp).offset(x = 20.dp))
        {
            Text(
                text = "Number of Persons:",
                fontSize = 18.sp,
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = people,
                onValueChange = { people = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text("Number of persons ", fontSize = 18.sp) },

                )
            Spacer(modifier = Modifier.height(20.dp))
            Text("The Number of Persons are: $people", fontSize = 18.sp)


            Spacer(modifier = Modifier.height(20.dp))

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 550.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                val userAmountDouble = userAmount.toDoubleOrNull() ?: 0.0
                val tipDouble = tip.toDoubleOrNull() ?: 0.0
                var currentLocalTotalAmount = userAmountDouble + tipDouble
                calculatedTotalAmount = currentLocalTotalAmount
                val numPeople = people.toIntOrNull() ?: 1 // Default to 1

                amountPerPerson = if (numPeople != 0) { // Update state
                    calculatedTotalAmount / numPeople
                } else {
                    calculatedTotalAmount
                }

            }) {Text("Calculate") }

            Text("Total Payable amount is: $calculatedTotalAmount", color = Color.Red, fontSize = 20.sp, modifier = Modifier.padding(16.dp))
            Spacer(modifier = Modifier.height(15.dp))
            Text("Amount per Head is: $amountPerPerson", color = Color.Red, fontSize = 20.sp, modifier = Modifier.padding(16.dp))
        }


    }


}
