package com.example.lab_exam
import android.os.Looper
import android.content.Context
import android.os.Handler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import java.util.Timer
import java.util.TimerTask

class SplashScreen {
    @Composable
    fun Display(nav: NavController, context: Context = LocalContext.current){
        Column(
            modifier=Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
            painter= painterResource(id = R.drawable.ic_launcher),
                contentDescription = "Logo",
                modifier = Modifier.size(150.dp)
                )
            Text(text = "Quiz App", fontSize = 40.sp, fontWeight = FontWeight.Bold)
        }

        LaunchedEffect(Unit){
            delay(3000)
            nav.navigate("/quiz-screen")
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun SplashScreenPreview(){
    SplashScreen().Display(NavController(LocalContext.current))
}