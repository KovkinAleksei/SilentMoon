package com.example.mobile_hard_mad_lab1.fragments

import android.annotation.SuppressLint
import android.graphics.Insets
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginBottom
import androidx.core.view.marginEnd
import androidx.core.view.marginStart
import androidx.core.view.marginTop
import com.example.mobile_hard_mad_lab1.R


class SignInFragment : Fragment() {
    private var marginIsFixed = false

    @SuppressLint("NewApi")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fixMargins(container)

        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    // Выравнивание отступов относительно статус бара и системной навигационной панели
    @RequiresApi(Build.VERSION_CODES.R)
    private fun fixMargins(container: ViewGroup?){
        container?.setOnApplyWindowInsetsListener{v, insets ->
            val systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            val welcomeTextView = container.findViewById<TextView>(R.id.welcomeBackTextView)

            if (!marginIsFixed) {
                addTopMargin(welcomeTextView, systemInsets)

                marginIsFixed = true
            }

            insets
        }
    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun addTopMargin(view: View, insets: Insets) {
        val params = view.layoutParams as ViewGroup.MarginLayoutParams
        params.setMargins(view.marginStart, view.marginTop + insets.top, view.marginEnd, view.marginBottom)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun addBottomMargin(view: View, insets: Insets) {
        val params = view.layoutParams as ViewGroup.MarginLayoutParams
        params.setMargins(view.marginStart, view.marginTop, view.marginEnd, view.marginBottom + insets.bottom)
    }
}