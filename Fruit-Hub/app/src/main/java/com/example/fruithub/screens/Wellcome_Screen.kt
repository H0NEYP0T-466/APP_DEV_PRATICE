package com.example.fruithub.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fruithub.R
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController

@Composable
fun Wellcome_Screen(navController: NavController)
{

   Column (modifier = Modifier.fillMaxSize().background(color = Color.White))
   {
       Box(modifier = Modifier.fillMaxWidth()
           .weight(0.065f)
           .background(brush = Brush.verticalGradient(colors =
               listOf(Color(0xFFFF8C42),Color(0xFFFF7A2B))))
           ,contentAlignment = Alignment.Center)
       {
           Box(
               modifier = Modifier.size(280.dp)
                   .background(color = Color.White.copy(alpha = 0.1f),shape = CircleShape)
               ,contentAlignment = Alignment.Center
           ) {
               Image(
                   painter = painterResource(R.drawable.fruit_basket_image),
                   contentDescription = "",
                   modifier = Modifier.size(184.dp, 206.dp)
               )

           }
       }
       Column (modifier = Modifier.fillMaxWidth().weight(0.035f).background(color = Color.White),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center
       )
       {
           Column (
                horizontalAlignment = Alignment.CenterHorizontally
           ){
           Text(
               text = "Get The Freshest Salad Combo",
               color = Color.Black,
               fontSize = 22.sp,
               fontWeight = FontWeight.Bold,
               textAlign = TextAlign.Center
           )
               Spacer(modifier = Modifier.height(26.dp))

           Text(
               text="We Deliver the best Freshest Salad in town order for a combo today !!!",
               color = Color.Black,
               fontSize = 18.sp,
               textAlign = TextAlign.Center
           )
               Spacer(modifier = Modifier.height(26.dp))

               Button(
                   onClick = {
                       navController.navigate("Name")
                       {
                           popUpTo("welcome") { inclusive = true }
                       }

                   },
                   modifier = Modifier
                       .fillMaxWidth()
                       .height(56.dp),
                   colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF8C42)),
                   shape = RoundedCornerShape(16.dp)
               ) {
                   Text(
                       text = "Let's Continue",
                       fontSize = 16.sp,
                       fontWeight = FontWeight.Medium,
                       color = Color.White
                   )
               }


           }
           }
       }

   }
