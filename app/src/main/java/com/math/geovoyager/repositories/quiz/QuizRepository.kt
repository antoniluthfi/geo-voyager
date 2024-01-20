package com.math.geovoyager.repositories.quiz

import com.math.geovoyager.pages.quiz.models.QuizData

interface QuizRepository {
    fun getQuestions(): List<QuizData>
}