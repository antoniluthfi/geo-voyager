package com.math.geovoyager.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import com.math.geovoyager.databinding.GlobalConfirmationPopupBinding

object GlobalPopup {
    fun showConfirmationPopup(
        context: Context,
        layoutInflater: LayoutInflater,
        message: String,
        confirmCallback: (() -> Unit)?
    ) {
        val dialog = Dialog(context)
        val confirmationPopupBinding = GlobalConfirmationPopupBinding.inflate(layoutInflater)
        dialog.setContentView(confirmationPopupBinding.root)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        confirmationPopupBinding.tvWarningTitle.text = message

        dialog.show()

        confirmationPopupBinding.btnClose.setOnClickListener {
            dialog.dismiss()
        }
        confirmationPopupBinding.btnCancel.setOnClickListener {
            dialog.dismiss()
        }
        confirmationPopupBinding.btnConfirm.setOnClickListener {
            dialog.dismiss()
            confirmCallback?.invoke()
        }
    }
}
