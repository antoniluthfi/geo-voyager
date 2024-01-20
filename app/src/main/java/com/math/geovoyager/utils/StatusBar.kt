package com.math.geovoyager.utils

import android.view.View
import android.view.Window
import androidx.fragment.app.FragmentActivity

object StatusBar {
    fun changeStatusBarColor(activity: FragmentActivity, colorResId: Int, darkContent: Boolean) {
        val window: Window = activity.window
        window.statusBarColor = activity.resources.getColor(colorResId)

        if (darkContent) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }
}