package com.example.lab_exam

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab_exam.ui.theme.Lab_examTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab_examTheme {
               Main()
            }
        }
    }
}

@Composable
fun Main(context: Context = LocalContext.current) {
    var controller = rememberNavController()
    NavHost(navController = controller, startDestination = "/") {
        composable("/") {
            SplashScreen().Display(nav = controller)
        }
        composable("/quiz-screen") {
            QuizScreen().Display(nav = controller)
        }
        composable("/score-screen/{total}/{correct}") {
            var correct = it.arguments?.getString("correct")
            var total = it.arguments?.getString("total")
            ScoreScreen().Display(nav = controller, correct=correct ?: "0", total=total ?: "0")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab_examTheme {
        Main()
    }
}