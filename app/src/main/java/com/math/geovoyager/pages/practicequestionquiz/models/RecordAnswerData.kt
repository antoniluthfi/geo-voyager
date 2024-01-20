package com.math.geovoyager.pages.practicequestionquiz.models

data class RecordAnswerData(
    val number: Int,
    val selectedAnswerIndex: Int,
    val isCorrect: Boolean,
    val score: Int
)
