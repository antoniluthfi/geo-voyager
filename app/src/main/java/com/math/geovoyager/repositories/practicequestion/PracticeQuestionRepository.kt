package com.math.geovoyager.repositories.practicequestion

import com.math.geovoyager.pages.practicequestions.models.PracticeQuestionData

interface PracticeQuestionRepository {
    suspend fun getMockData(): List<PracticeQuestionData>
}