package com.example.fruithub.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fruithub.R


data class Combo(val name: String, val price: String, val imageRes: Int)

 val combos = listOf(
    Combo("Apple Limb Combo", "$124", R.drawable.food_1),
    Combo("Honey Limb Combo", "$231", R.drawable.food_2),
    Combo("Fruit Limb Combo", "$114", R.drawable.food_4),
    Combo("Grape Limb Combo", "$155", R.drawable.food_1),
    Combo("Stars Limb Combo", "$199", R.drawable.food_2),
    Combo("Cats Limb Combo", "$178", R.drawable.food_4),
    Combo("Dogs Limb Combo", "$165", R.drawable.food_1),
    Combo("Movie Limb Combo", "$188", R.drawable.food_2),
    Combo("Class Limb Combo", "$142", R.drawable.food_4),
    Combo("Music Limb Combo", "$120", R.drawable.food_1)
)

@Composable
fun RecomendedComboCard(modifier: Modifier = Modifier, combo: Combo) {
    Card(
        modifier = Modifier.width(152.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(26.dp)) {
            Image(
                painter = painterResource(id = combo.imageRes),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = combo.name, fontSize = 16.sp, fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = combo.price, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFF8C42))
            Spacer(modifier = Modifier.height(6.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
                Icon(Icons.Default.FavoriteBorder, contentDescription = null, tint = Color.Red, modifier = Modifier.size(20.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    Icon(Icons.Default.Add, contentDescription = null, tint = Color.Black, modifier = Modifier.size(20.dp))
                }
            }


        }
    }
}

@Composable
fun Home_Screen(user_name: String, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(Icons.Default.Menu, contentDescription = null, tint = Color.Black, modifier = Modifier.size(30.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = painterResource(R.drawable.shopping_basket), contentDescription = null)
                Spacer(modifier = Modifier.size(4.dp))
                Text("My Basket", color = Color.Black)
            }
        }

        Text("Hello $user_name! What fruit salad combo do you want today?", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF3F1F1), RoundedCornerShape(16.dp))
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    navController.navigate("Search") {
                        popUpTo("home") { inclusive = true }
                    }
                },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF3F1F1)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("\uD83D\uDD0D Search for fruit salad combo", fontSize = 18.sp, color = Color.Black)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
        Text("Recommended Combos", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)

        LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(vertical = 10.dp)) {
            items(combos) { combo ->
                RecomendedComboCard(combo = combo)
            }
        }

        LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(12.dp)) {
            items(listOf("Hottest", "Popular", "New Combo", "Top","Lgu","Honeypot","CS","AI")) { category ->
                Text(
                    text = category,
                    fontSize = 20.sp,
                    fontWeight = if (category == "Hottest") FontWeight.Bold else FontWeight.Medium,
                    color = Color.Black
                )
            }
        }

        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.padding(vertical = 8.dp)) {
            items(combos) { combo ->
                RecomendedComboCard(combo = combo)
            }
        }
    }
}
