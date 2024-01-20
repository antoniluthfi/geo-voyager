package com.math.geovoyager.pages.quiz.models

data class QuizData(
    val number: Int,
    val question: String,
    val answers: List<AnswerData>,
    val image: Int?
)