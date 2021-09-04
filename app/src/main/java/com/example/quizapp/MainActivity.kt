package com.example.quizapp

import android.graphics.Color
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
    private lateinit var btnPrev: Button
    private lateinit var txtQuestion: TextView

    private lateinit var gameModel: GameModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameModel = GameModel(this)

        txtQuestion = findViewById(R.id.question_text)
        btnTrue = findViewById(R.id.true_button)
        btnFalse = findViewById(R.id.false_button)
        btnNext = findViewById(R.id.next_button)
        btnPrev = findViewById(R.id.prev_button)

        txtQuestion.text = gameModel.getCurrentQuestion().text

        fun markButtonDisable(button: Button, flag: Boolean = false) {
            button.setBackgroundColor(Color.parseColor(getString(R.string.grey_color)))
            button.isEnabled = false
            txtQuestion.setTextColor(Color.parseColor("#ff0000"))
        }

        fun markButtonEnable(button: Button) {
            txtQuestion.setTextColor(Color.parseColor("#FFFFFF"))
            button.isEnabled = true
        }
        
        btnTrue.setOnClickListener{ v: View ->
            val answer = gameModel.getCurrentQuestion().answer
            if (answer) {
                Toast.makeText(this, R.string.right_text, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, R.string.wrong_text, Toast.LENGTH_SHORT).show()
            }
            gameModel.setAnswered()
            markButtonDisable(btnTrue);
            markButtonDisable(btnFalse);
        }

        btnFalse.setOnClickListener{ v: View ->
            val answer = gameModel.getCurrentQuestion().answer
            if (!answer) {
                Toast.makeText(this, R.string.right_text, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, R.string.wrong_text, Toast.LENGTH_SHORT).show()
            }
            gameModel.setAnswered()
            markButtonDisable(btnTrue);
            markButtonDisable(btnFalse);
        }

        btnNext.setOnClickListener{ v: View ->
            val nextQuestion = gameModel.nextQuestion()
            btnTrue.setBackgroundColor(Color.parseColor(getString(R.string.green_color)))
            btnFalse.setBackgroundColor(Color.parseColor(getString(R.string.red_color)))
            txtQuestion.text = nextQuestion.text
            if (nextQuestion.answered) {
                Toast.makeText(this, R.string.question_answered, Toast.LENGTH_SHORT).show()
                markButtonDisable(btnFalse);
                markButtonDisable(btnTrue);
            } else {
                markButtonEnable(btnFalse)
                markButtonEnable(btnTrue)
            }
        }

        btnPrev.setOnClickListener{ v: View ->
            val prevQuestion = gameModel.prevQuestion()
            btnTrue.setBackgroundColor(Color.parseColor(getString(R.string.green_color)))
            btnFalse.setBackgroundColor(Color.parseColor(getString(R.string.red_color)))
            txtQuestion.text = prevQuestion.text
            if (prevQuestion.answered) {
                Toast.makeText(this, R.string.question_answered, Toast.LENGTH_SHORT).show()
                markButtonDisable(btnFalse);
                markButtonDisable(btnTrue);
            } else {
                markButtonEnable(btnFalse)
                markButtonEnable(btnTrue)
            }
        }
    }
}
