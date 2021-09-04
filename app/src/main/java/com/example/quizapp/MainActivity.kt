package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnNext: Button
    private lateinit var txtQuestion: TextView

    private lateinit var gameModel: GameModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameModel = GameModel()

        txtQuestion = findViewById(R.id.question_text)
        btnTrue = findViewById(R.id.true_button)
        btnFalse = findViewById(R.id.false_button)
        btnNext = findViewById(R.id.next_button)

        txtQuestion.text = gameModel.getCurrentQuestion().text
        
        btnTrue.setOnClickListener{ v: View ->
            Toast.makeText(this, R.string.right_text, Toast.LENGTH_SHORT).show()
        }

        btnFalse.setOnClickListener{ v: View ->
            Toast.makeText(this, R.string.wrong_text, Toast.LENGTH_SHORT).show()
        }

        btnNext.setOnClickListener{ v: View ->
            txtQuestion.text = gameModel.nextQuestion().text
        }
    }
}