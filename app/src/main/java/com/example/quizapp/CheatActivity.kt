package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class CheatActivity : AppCompatActivity() {

    private lateinit var txtQuestion: TextView
    private lateinit var btnCheat: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        txtQuestion = findViewById(R.id.question_text)
        btnCheat = findViewById(R.id.cheat_button)

        if(intent != null){
            txtQuestion.text = intent.getStringExtra("EXTRA_QUESTION_TEXT")
        }


        btnCheat.setOnClickListener{ v: View ->

            val intent = Intent()
            intent.putExtra("CHEAT_TEST_TEXT", "Probando")

            setResult(RESULT_OK)
        }
    }
}