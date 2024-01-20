package com.math.geovoyager.repositories.menu

import com.math.geovoyager.pages.home.models.MenuData

interface MenuRepository {
    suspend fun getMockData(): List<MenuData>
}