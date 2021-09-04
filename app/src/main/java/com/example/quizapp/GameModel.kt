package com.example.quizapp

import android.content.Context
import android.content.res.Resources

class GameModel (private val context: Context) {
    private val questions = listOf<Question>(
        Question(context.getString(R.string.question1), true, false),
        Question(context.getString(R.string.question2), false, false),
        Question(context.getString(R.string.question3), true, false),
        Question(context.getString(R.string.question4), false, false),
        Question(context.getString(R.string.question5), true, false),
        Question(context.getString(R.string.question6), false, false),
        Question(context.getString(R.string.question7), false, false),
        Question(context.getString(R.string.question8), true, false),
    )

    private var currentQuestionIndex = 0

    fun getCurrentQuestion() = questions[currentQuestionIndex]

    fun setAnswered() {
        questions[currentQuestionIndex].answered = true
    }

    fun nextQuestion() : Question {
        currentQuestionIndex = (currentQuestionIndex + 1) % questions.size
        return questions[currentQuestionIndex]
    }

    fun prevQuestion() : Question {
        if (currentQuestionIndex - 1 < 0) {
            currentQuestionIndex = questions.size -1
        } else {
            currentQuestionIndex -= 1
        }
        return questions[currentQuestionIndex]
    }
}