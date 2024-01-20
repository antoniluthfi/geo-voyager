package com.math.geovoyager.repositories.practicequestionquiz

import com.math.geovoyager.pages.practicequestionquiz.models.QuestionData

interface PracticeQuestionQuizRepository {
    fun getLOTSQuestions(): List<QuestionData>
    fun getMOTSQuestions(): List<QuestionData>
    fun getHOTSQuestions(): List<QuestionData>
}