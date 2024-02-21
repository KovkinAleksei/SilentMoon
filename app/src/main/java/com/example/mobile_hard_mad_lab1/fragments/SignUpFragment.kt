package com.example.mobile_hard_mad_lab1.fragments

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.WindowInsetsCompat
import com.example.mobile_hard_mad_lab1.ContinueMethodFragment
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.common.MarginFix
import com.example.mobile_hard_mad_lab1.databinding.FragmentSignInBinding
import com.example.mobile_hard_mad_lab1.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private var marginIsFixed = false
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

        val privacyPolicy = binding.privacyPolicy

        privacyPolicy.setOnClickListener {
            val toast = Toast.makeText(context, privacyPolicyMessage, Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    // Выравнивание отступов относительно статус бара и системной навигационной панели
    @RequiresApi(Build.VERSION_CODES.R)
    private fun fixMargins(container: ViewGroup?) {
        container?.setOnApplyWindowInsetsListener{v, insets ->
            val systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            val createAccountTextView = binding.createAccountTextView
            val getStartedButton = binding.getStartedButton

            if (!marginIsFixed) {
                MarginFix.addTopMargin(createAccountTextView, systemInsets)
                MarginFix.addBottomMargin(getStartedButton, systemInsets)

                marginIsFixed = true
            }

            insets
        }
    }
}