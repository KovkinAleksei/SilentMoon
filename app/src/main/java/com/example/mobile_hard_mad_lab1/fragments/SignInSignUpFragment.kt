package com.example.mobile_hard_mad_lab1.fragments

import android.annotation.SuppressLint
import android.graphics.Insets
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginBottom
import androidx.core.view.marginEnd
import androidx.core.view.marginStart
import androidx.core.view.marginTop
import androidx.navigation.fragment.findNavController
import com.example.mobile_hard_mad_lab1.R

class SignInSignUpFragment : Fragment() {
    private var marginIsFixed = false

    @SuppressLint("NewApi")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fixMargins(container)

        return inflater.inflate(R.layout.fragment_sign_in_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val logInButton = view.findViewById<TextView>(R.id.logInTextView)
        val navController = findNavController()

        logInButton.setOnClickListener {
            navController.navigate(R.id.signInFragment)
        }
    }

    // Выравнивание отступов относительно статус бара и системной навигационной панели
    @RequiresApi(Build.VERSION_CODES.R)
    private fun fixMargins(container: ViewGroup?){
        container?.setOnApplyWindowInsetsListener{v, insets ->
            val systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            val logo = container.findViewById<ImageView>(R.id.logoImageView)
            val logIn = container.findViewById<TextView>(R.id.logInTextView)
            val haveAnAccount = container.findViewById<TextView>(R.id.haveAccountTextView)

            if (!marginIsFixed) {
                addTopMargin(logo, systemInsets)
                addBottomMargin(logIn, systemInsets)
                addBottomMargin(haveAnAccount, systemInsets)

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