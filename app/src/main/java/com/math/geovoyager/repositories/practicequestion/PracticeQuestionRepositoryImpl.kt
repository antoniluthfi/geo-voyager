package com.math.geovoyager.repositories.practicequestion

import com.math.geovoyager.pages.practicequestions.models.PracticeQuestionData

class PracticeQuestionRepositoryImpl : PracticeQuestionRepository {
    override suspend fun getMockData(): List<PracticeQuestionData> {
        return listOf(
            PracticeQuestionData(
                "SOAL LOTS",
                "Keterampilan berpikir tingkat rendah, dimana fokus utama yang perlu dipenuhi adalah mampu menyalin, meniru, menghafal, mengingat, dan mengikuti berbagai arahan.",
                "#199425"
            ),
            PracticeQuestionData(
                "SOAL MOTS",
                "Keterampilan berpikir menggunakan logika, yang termasuk dalam kategori tingkat menengah.",
                "#D6AB13"
            ),
            PracticeQuestionData(
                "SOAL HOTS",
                "Soal yang melatih kemampuan berpikir individu pada tingkat yang lebih tinggi meliputi cara berpikir secara kritis, logis, metakognisi, dan kreatif.",
                "#D61313"
            ),
        )
    }
}