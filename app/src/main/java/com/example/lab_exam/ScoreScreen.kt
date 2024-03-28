package com.example.lab_exam

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

class ScoreScreen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Display(nav:NavController, correct:String, total:String){
        Scaffold(
            topBar = { TopAppBar(title = { Text(text = "Final Report") }, navigationIcon = {
                Image(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            })}
        ) {
            Column(
                Modifier
                    .padding(it)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
            ) {
                xRow(first = "Subject: ", second = "Geography")
                xRow(first = "Correct: ", second = correct)
                xRow(first = "Incorrect: ", second = (total.toInt() - correct.toInt()).toString())
                xRow(first = "Earned: ", second = "11")
                xRow(first = "Overall Points: ", second = "227")
                xRow(first = "Date: ", second = "09 Dec 2020 01:33 PM")

                Button(onClick = { nav.navigate("/quiz-screen") }) {
                    Text(text = "Start Again")
                }
            }
        }
    }

    @Composable
    fun xRow(first:String, second:String){
        Row {
            Text(text = first, fontSize = 18.sp)
            Text(text = second, fontSize = 15.sp)
        }
    }



}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ScoreScreenPreview(){
    ScoreScreen().Display(NavController(LocalContext.current), "3", "5")
}