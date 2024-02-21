package com.example.mobile_hard_mad_lab1.common

import android.graphics.Insets
import android.os.Build
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.marginBottom
import androidx.core.view.marginEnd
import androidx.core.view.marginStart
import androidx.core.view.marginTop

// Редактирование отступов
class MarginFix {
    companion object {
        @RequiresApi(Build.VERSION_CODES.R)
        fun addTopMargin(view: View, insets: Insets) {
            val params = view.layoutParams as ViewGroup.MarginLayoutParams
            params.setMargins(view.marginStart, view.marginTop + insets.top, view.marginEnd, view.marginBottom)
        }

        @RequiresApi(Build.VERSION_CODES.R)
        fun addBottomMargin(view: View, insets: Insets) {
            val params = view.layoutParams as ViewGroup.MarginLayoutParams
            params.setMargins(view.marginStart, view.marginTop, view.marginEnd, view.marginBottom + insets.bottom)
        }
    }
}