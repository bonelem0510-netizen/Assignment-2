package com.example.assignment220

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment220.ui.theme.Assignment220Theme

class MainActivity : ComponentActivity() {

    private val questions = arrayOf(
        "Tinfoil bridges AAA batteries to fit AA slots.",
        "Garlic makes picking up yolks easier.",
        "You can use a potato to charge your phone.",
        "Tape lifts stickers cleanly and quickly.",
        "Saltwater makes gummy sweets massive"
    )
    private val answers = arrayOf(true, true, false, true, false)

    private var currentQuestions = 0

    private var score = 0

    private val feedbackList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.act_questions)
    }


    private fun showWelcomeScreen() {
        setContentView(R.layout.act_welcome)
        val startButton = findViewById<Button>(R.id.btnShow)
        startButton.setOnClickListener {
            currentQuestions = 0
            score = 0
            feedbackList.clear()
            showQuestionScreen()
        }
    }

    private fun showQuestionScreen() {
        setContentView(R.layout.act_questions)

        val questionText = findViewById<TextView>(R.id.questionText)
        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val feedbackText = findViewById<TextView>(R.id.feedbackText)
        val nextButton = findViewById<Button>(R.id.nextButton)

        questionText.text = questions[currentQuestions]
        feedbackText.text = ""

        var answered = false

        trueButton.setOnClickListener {
            if (!answered) {
                checkAnswer(true, feedbackText)
                answered = true
            }
        }

        falseButton.setOnClickListener {
            if (!answered) {
                checkAnswer(false, feedbackText)
                answered = true
            }
        }

        nextButton.setOnClickListener {
            currentQuestions++
            if (currentQuestions < questions.size) {
                showQuestionScreen()
            } else {
                showQuestionScreen()
            }
        }
    }

    private fun checkAnswer(userAnswer: Boolean, feedbackText: TextView){
        val correct = answers[currentQuestions]
        if (userAnswer == correct) {
            feedbackText.text = "Correct"
            score++
            feedbackList.add("Q${currentQuestions + 1}")
        }else {
            feedbackText.text = "Incorrect"
            feedbackList.add("Q${currentQuestions + 1}")
        }
    }

    private fun showScoreScreen(){
        setContentView(R.layout.act_score)
    }
}






