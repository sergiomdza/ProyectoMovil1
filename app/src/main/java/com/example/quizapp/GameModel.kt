package com.example.quizapp

class GameModel {
    private val questions = listOf<Question>(
        Question("¿La luna es de queso?", true),
        Question("¿La tierra es plana?", false),
        Question("¿El cielo es azul?", true),
        Question("¿China creo el covid?", false),
        Question("¿El hombre llegó a la luna?", true),
        Question("¿El 5G hace daño?", false),
        Question("¿El cielo se cae?", false),
        Question("¿Realmente tiene otros datos?", true),
    )

    private var currentQuestionIndex = 0

    fun getCurrentQuestion() = questions[currentQuestionIndex]

    fun nextQuestion() : Question {
        currentQuestionIndex = (currentQuestionIndex + 1) % questions.size
        return questions[currentQuestionIndex]
    }
}