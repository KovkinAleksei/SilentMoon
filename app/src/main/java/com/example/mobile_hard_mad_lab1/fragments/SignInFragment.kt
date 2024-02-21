package com.example.mobile_hard_mad_lab1.fragments

import android.annotation.SuppressLint
import android.graphics.Insets
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginBottom
import androidx.core.view.marginEnd
import androidx.core.view.marginStart
import androidx.core.view.marginTop
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.common.MarginFix
import com.example.mobile_hard_mad_lab1.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {
    private var marginIsFixed = false
    private lateinit var binding : FragmentSignInBinding

    @SuppressLint("NewApi")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        fixMargins(container)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    // Выравнивание отступов относительно статус бара и системной навигационной панели
    @RequiresApi(Build.VERSION_CODES.R)
    private fun fixMargins(container: ViewGroup?){
        container?.setOnApplyWindowInsetsListener{v, insets ->
            val systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            val welcomeTextView = binding.welcomeBackTextView
            val haveAccountLayOut = binding.constraintLayout

            if (!marginIsFixed) {
                MarginFix.addTopMargin(welcomeTextView, systemInsets)
                MarginFix.addBottomMargin(haveAccountLayOut, systemInsets)

                marginIsFixed = true
            }

            insets
        }
    }
}