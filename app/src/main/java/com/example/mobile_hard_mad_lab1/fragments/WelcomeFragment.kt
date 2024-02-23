package com.example.mobile_hard_mad_lab1.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.findNavController
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.common.MarginFix
import com.example.mobile_hard_mad_lab1.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private var marginIsFixed = false
    private lateinit var binding : FragmentWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        fixMargins(container)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val navController = findNavController()

        val getStartedButton = binding.getStartedButton

        getStartedButton.setOnClickListener {
            navController.navigate(R.id.chooseTopicFragment)
            marginIsFixed = false
        }
    }

    // Выравнивание отступов относительно статус бара и системной навигационной панели
    @RequiresApi(Build.VERSION_CODES.R)
    private fun fixMargins(container: ViewGroup?) {
        container?.setOnApplyWindowInsetsListener{v, insets ->
            val systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            val logoImageView = binding.logoImageView
            val getStartedButton = binding.getStartedButton
            val hillBase = binding.hillBaseConstraintLayout

            if (!marginIsFixed) {
                MarginFix.addTopMargin(logoImageView, systemInsets)
                MarginFix.addBottomMargin(getStartedButton, systemInsets)
                MarginFix.addBottomMargin(hillBase, systemInsets)

                marginIsFixed = true
            }

            insets
        }
    }
}