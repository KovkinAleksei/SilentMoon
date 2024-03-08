package com.example.mobile_hard_mad_lab1.signUpScreen

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.findNavController
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.common.MarginFix
import com.example.mobile_hard_mad_lab1.databinding.FragmentSignUpBinding
import com.example.mobile_hard_mad_lab1.common.fragments.ContinueMethodFragment

class SignUpFragment : Fragment() {
    private lateinit var binding : FragmentSignUpBinding
    private val privacyPolicyMessage : String = "Тут будет политика конфидециальности"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        parentFragmentManager.beginTransaction().replace(R.id.continue_method, ContinueMethodFragment()).commit()

        fixMargins(container)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        val privacyPolicy = binding.privacyPolicy
        val getStartedButton = binding.getStartedButton

        privacyPolicy.setOnClickListener {
            val toast = Toast.makeText(context, privacyPolicyMessage, Toast.LENGTH_SHORT)
            toast.show()
        }

        getStartedButton.setOnClickListener {
            navController.navigate(R.id.welcomeFragment)
        }
    }

    // Выравнивание отступов относительно статус бара и системной навигационной панели
    @RequiresApi(Build.VERSION_CODES.R)
    private fun fixMargins(container: ViewGroup?) {
        container?.setOnApplyWindowInsetsListener{v, insets ->
            val windowInsets = ViewCompat.getRootWindowInsets(v)
            val systemInsets = windowInsets?.getInsets(WindowInsetsCompat.Type.systemBars())

            val createAccountTextView = binding.createAccountTextView
            val getStartedButton = binding.getStartedButton

            MarginFix.addTopMargin(createAccountTextView, systemInsets)
            MarginFix.addBottomMargin(getStartedButton, systemInsets)

            insets
        }
    }
}