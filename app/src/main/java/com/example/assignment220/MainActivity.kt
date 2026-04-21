package com.example.assignment220

import android.os.Bundle
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
}