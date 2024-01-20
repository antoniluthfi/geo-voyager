package com.math.geovoyager.repositories.menu

import com.math.geovoyager.R
import com.math.geovoyager.pages.home.models.MenuData

class MenuRepositoryImpl: MenuRepository {
    override suspend fun getMockData(): List<MenuData> {
        return listOf(
            MenuData(R.drawable.ic_atp, "ATP"),
            MenuData(R.drawable.ic_cp, "CP"),
            MenuData(R.drawable.ic_materi, "Materi"),
            MenuData(R.drawable.ic_video, "Video"),
            MenuData(R.drawable.ic_latihan_soal, "Latihan Soal"),
            MenuData(R.drawable.ic_quiz, "Quiz"),
        )
    }
}