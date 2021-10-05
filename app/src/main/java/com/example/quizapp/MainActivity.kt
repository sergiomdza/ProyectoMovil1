package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnNext: Button
    private lateinit var btnCheat: Button
    private lateinit var txtQuestion: TextView

 //   private lateinit var gameModel: GameModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("QUIZZAPP_DEBUG", "OnCreate()...")

        val gameModel: GameModel by viewModels()
        // gameModel = GameModel()

        /* if (savedInstanceState != null) {
            gameModel.setCurrentQuestionIndex(savedInstanceState.getInt("KEY_CURRENT_QUESTION_INDEX"))
        }*/

        txtQuestion = findViewById(R.id.question_text)
        btnTrue = findViewById(R.id.true_button)
        btnFalse = findViewById(R.id.false_button)
        btnNext = findViewById(R.id.next_button)
        btnCheat = findViewById(R.id.cheat_button)

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

        btnCheat.setOnClickListener{ v: View ->
            val intent = Intent(this, CheatActivity::class.java)
            intent.putExtra("EXTRA_QUESTION_TEXT", gameModel.getCurrentQuestion().text)
            startActivityForResult(intent, 5)

            //startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode) {
            5 -> {
                Toast.makeText(this, "CLOSED", Toast.LENGTH_SHORT).show()
                when(resultCode) {
                    RESULT_OK -> Toast.makeText(
                        this,
                        "OK ${data!!.getStringExtra("CHEAT_TEST_TEXT")}",
                        Toast.LENGTH_SHORT
                    ).show()

                    RESULT_CANCELED -> Toast.makeText(this, "CANCELED", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onStart() {
       super.onStart()
        Log.d("QUIZZAPP_DEBUG", "OnStar()...")
    }

    override fun onResume() {
        super.onResume()
        Log.d("QUIZZAPP_DEBUG", "OnResume()...")
    }

    override fun onPause() {
        super.onPause()
        Log.d("QUIZZAPP_DEBUG", "OnPause()...")
    }

    override fun onStop() {
        super.onStop()
        Log.d("QUIZZAPP_DEBUG", "OnStop()...")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("QUIZZAPP_DEBUG", "onDestroy()...")
    }

    /* override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("QUIZZAPP_DEBUG", "onSaveInstanceState()...")

        outState.putInt("KEY_CURRENT_QUESTION_INDEX", gameModel.getCurrentQuestionIndex())
    } */
}