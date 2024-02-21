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
import com.example.mobile_hard_mad_lab1.ContinueMethodFragment
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.common.MarginFix
import com.example.mobile_hard_mad_lab1.databinding.FragmentSignInSignUpBinding

class SignInSignUpFragment : Fragment() {
    private var marginIsFixed = false
    private lateinit var binding : FragmentSignInSignUpBinding

    @SuppressLint("NewApi")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInSignUpBinding.inflate(inflater, container, false)
        fixMargins(container)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val logInButton = binding.logInTextView
        val signUpButton = binding.signUpButton
        val navController = findNavController()

        logInButton.setOnClickListener {
            navController.navigate(R.id.signInFragment)
            marginIsFixed = false
        }

        signUpButton.setOnClickListener {
            navController.navigate(R.id.signUpFragment)
            marginIsFixed = false
        }
    }

    // Выравнивание отступов относительно статус бара и системной навигационной панели
    @RequiresApi(Build.VERSION_CODES.R)
    private fun fixMargins(container: ViewGroup?){
        container?.setOnApplyWindowInsetsListener{v, insets ->
            val systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            val logo = binding.logoImageView
            val logIn = binding.logInTextView
            val haveAnAccount = binding.haveAccountTextView

            if (!marginIsFixed) {
                MarginFix.addTopMargin(logo, systemInsets)
                MarginFix.addBottomMargin(logIn, systemInsets)
                MarginFix.addBottomMargin(haveAnAccount, systemInsets)

                marginIsFixed = true
            }

            insets
        }
    }
}