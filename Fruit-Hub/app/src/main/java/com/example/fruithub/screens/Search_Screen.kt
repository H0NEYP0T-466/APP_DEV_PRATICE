package com.example.fruithub.screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
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
fun Search_Screen()
{
    var search_query by rememberSaveable { mutableStateOf("") }
    Column (modifier = Modifier.background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center
    )
    {
        Image(painter = painterResource(R.drawable.logo)
            , contentDescription = null,
            modifier = Modifier.size(350.dp,370.dp)
        )
        Column (modifier=Modifier.offset(y=0.dp).padding(horizontal = 20.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center)
        {
            TextField(
                value = search_query,
                onValueChange = { search_query = it },
                label = { Text(" \uD83D\uDD0D What do you want to search?") },
                modifier = Modifier.fillMaxWidth()
            )


            Spacer(modifier = Modifier.height(36.dp))
            Column (modifier = Modifier.fillMaxWidth().weight(0.035f)){
                Text("Results:", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                Spacer(modifier = Modifier.height(8.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(vertical = 10.dp)) {
                    items(SearchFun(search_query, combos)) { combo ->
                        Searched(combo = combo)
                    }
                }

            }
        }

    }




}
@Composable
fun Searched(modifier: Modifier = Modifier, combo: Combo) {
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
            Text(
                text = combo.price,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFF8C42)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start)
            {
                Icon(Icons.Default.FavoriteBorder, contentDescription = null, tint = Color.Red, modifier = Modifier.size(20.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End)
                {
                    Icon(Icons.Default.Add, contentDescription = null, tint = Color.Black, modifier = Modifier.size(20.dp))
                }
            }

        }
    }
}

fun SearchFun(query: String, combos: List<Combo>): List<Combo>
{
    var new_list = listOf<Combo>()
    var i=0
    while( i < combos.size)
    {
        if(combos[i].name.contains(query))
        {
            new_list = new_list + combos[i]
        }
        i++
    }
    return new_list
}

