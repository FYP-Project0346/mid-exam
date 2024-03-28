package com.example.lab_exam

import Question
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

class QuizScreen {
    @Composable
    fun Display(nav: NavController, context: Context = LocalContext.current) {
        var questions = listOf(
            Question(
                questionText = "What is the capital of France?",
                options = listOf("Paris", "London", "Berlin", "Madrid"),
                userAnswer = null
            ),
            Question(
                questionText = "Who wrote 'Hamlet'?",
                options = listOf("William Shakespeare", "Charles Dickens", "Leo Tolstoy", "Mark Twain"),
                userAnswer = null
            ),

                    Question(
                    questionText = "What is the smallest planet in our solar system?",
            options = listOf("Mercury", "Venus", "Earth", "Mars"),
            userAnswer = null
        ),

            Question(
                questionText = "Which element has the chemical symbol 'O'?",
                options = listOf("Oxygen","Gold",  "Silver", "Iron"),
                userAnswer = null
            ),

            Question(
                questionText = "In which country is the Great Barrier Reef located?",
                options = listOf("Australia","Brazil", "India",   "Egypt"),
                userAnswer = null
            ),

        )
        var selectedQuestion by remember {
            mutableStateOf(0)
        };

        var selectedOption by remember {
            mutableStateOf(35)
        };

        var correctOptions by remember{
            mutableStateOf(0)
        }



        Column(
            modifier= Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = questions[selectedQuestion].questionText)
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                RadioButton(selected = selectedOption==0, onClick = {
                    selectedOption = 0;
                })
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = questions[selectedQuestion].options[0])
            }
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                RadioButton(selected = selectedOption==1, onClick = {
                    selectedOption = 1;
                })
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = questions[selectedQuestion].options[1])
            }
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                RadioButton(selected = selectedOption==2, onClick = {
                    selectedOption = 2;
                })
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = questions[selectedQuestion].options[2])
            }
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                RadioButton(selected = selectedOption==3, onClick = {
                    selectedOption = 3;
                })
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = questions[selectedQuestion].options[3])
            }


            Text(text = "Current Question ${selectedQuestion + 1}")

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                if (selectedQuestion < questions.size-1){
                    if (selectedOption == 35){
                        Toast.makeText(context, "Plz Select Option", Toast.LENGTH_SHORT).show()
                    }else{
                        selectedQuestion++
                        if (selectedOption == 0){
                            correctOptions++
                        }
                        selectedOption = 35
                    }
                }else{
                    if (selectedOption == 35){
                        Toast.makeText(context, "Plz Select Option", Toast.LENGTH_SHORT).show()
                    }else{
                        if (selectedOption == 0){
                            correctOptions++
                        }
                    }
                    nav.navigate("/score-screen/${questions.size}/${correctOptions}")
                }
            }) {
                Text(text = "Next")
            }

        }


    }

    
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun QuizScreenPreview(){
    QuizScreen().Display(NavController(LocalContext.current))
}