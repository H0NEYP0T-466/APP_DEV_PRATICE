package com.example.fruithub.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fruithub.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController)
{
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate("welcome")
        {
            popUpTo("splash") {inclusive = true}
        }

    }

    Column (modifier = Modifier.fillMaxSize().background(color = Color.White)
        ,horizontalAlignment = Alignment.CenterHorizontally
        ,verticalArrangement = Arrangement.Center
    )
    {
        Image(painter = painterResource(R.drawable.logo)
            , contentDescription = null,
            modifier = Modifier.size(350.dp,420.dp)
        )
    }
}
