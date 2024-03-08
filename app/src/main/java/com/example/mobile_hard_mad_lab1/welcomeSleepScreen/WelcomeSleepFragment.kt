package com.example.mobile_hard_mad_lab1.welcomeSleepScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.databinding.FragmentWelcomeSleepBinding

class WelcomeSleepFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeSleepBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeSleepBinding.inflate(inflater, container, false)

        val navController = findNavController()
        val getStartedButton = binding.getStartedButton

        getStartedButton.setOnClickListener {
            navController.navigate(R.id.action_welcomeSleepFragment_to_sleepFragment)
        }

        return binding.root
    }
}