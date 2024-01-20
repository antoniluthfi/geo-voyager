package com.math.geovoyager.pages.practicequestionquiz.models

data class QuestionData(
    val number: Int,
    val question: String,
    val answers: List<AnswerData>,
    val image: Int?
)