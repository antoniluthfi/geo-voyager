package com.math.geovoyager.pages.quiz.models

data class RecordAnswerData(
    val number: Int,
    val selectedAnswerIndex: Int,
    val isCorrect: Boolean,
    val score: Int
)
