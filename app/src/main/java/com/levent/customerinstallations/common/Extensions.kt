package com.levent.customerinstallations.common

import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import com.levent.customerinstallations.databinding.PopupInfoBinding

fun Dialog.setWidthPercent(percentage: Int) {
    val percent = percentage.toFloat() / 100
    val dm = Resources.getSystem().displayMetrics
    val rect = dm.run { Rect(0, 0, widthPixels, heightPixels) }
    val percentWidth = rect.width() * percent
    window?.setLayout(percentWidth.toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
}

fun Context.showPopup(
    @DrawableRes iconId: Int,
    title: String,
    dismissListener: (() -> Unit?)? = null,
) {
    Dialog(this).apply {
        val binding = PopupInfoBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)
        setWidthPercent(75)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setCancelable(true)
        setCanceledOnTouchOutside(true)
        setOnCancelListener {
            dismissListener?.invoke()
        }

        with(binding) {
            ivImage.setImageResource(iconId)
            tvMessage.text = title
            btnOkay.setOnClickListener {
                dismiss()
                dismissListener?.invoke()
            }
        }

        show()
    }
}