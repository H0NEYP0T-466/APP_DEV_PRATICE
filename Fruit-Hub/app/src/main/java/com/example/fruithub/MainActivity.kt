package com.example.fruithub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fruithub.screens.Home_Screen
import com.example.fruithub.screens.Name_ask
import com.example.fruithub.screens.RecomendedComboCard
import com.example.fruithub.screens.Search_Screen
import com.example.fruithub.screens.SplashScreen
import com.example.fruithub.screens.Wellcome_Screen
import com.example.fruithub.ui.theme.FruitHubTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavigation()


        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("Name") { Name_ask(navController) }
        composable("welcome") { Wellcome_Screen(navController) }
        composable("Search") { Search_Screen() }
        composable("home/{user_name}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("user_name").takeUnless { it.isNullOrBlank() } ?: "Guest"
            Home_Screen(user_name = name,navController)
        }

    }
}

