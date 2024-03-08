package com.example.mobile_hard_mad_lab1.signInScreen

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.common.MarginFix
import com.example.mobile_hard_mad_lab1.common.fragments.ContinueMethodFragment
import com.example.mobile_hard_mad_lab1.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {
    private lateinit var binding: FragmentSignInBinding

    @SuppressLint("NewApi", "CommitTransaction")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        parentFragmentManager.beginTransaction()
            .replace(R.id.continue_method, ContinueMethodFragment()).commit()

        fixMargins(container)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        val signUpButton = binding.signUpTextView
        val logInButton = binding.logInButton

        signUpButton.setOnClickListener {
            navController.navigate(R.id.signUpFragment)
        }

        logInButton.setOnClickListener {
            navController.navigate(R.id.welcomeFragment)
        }
    }

    // Выравнивание отступов относительно статус бара и системной навигационной панели
    @RequiresApi(Build.VERSION_CODES.R)
    private fun fixMargins(container: ViewGroup?) {
        container?.setOnApplyWindowInsetsListener { v, insets ->
            val windowInsets = ViewCompat.getRootWindowInsets(v)
            val systemInsets = windowInsets?.getInsets(WindowInsetsCompat.Type.systemBars())

            val welcomeTextView = binding.welcomeBackTextView
            val haveAccountFlow = binding.haveAccountFlow

            MarginFix.addTopMargin(welcomeTextView, systemInsets)
            MarginFix.addBottomMargin(haveAccountFlow, systemInsets)

            insets
        }
    }
}