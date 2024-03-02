package com.example.mobile_hard_mad_lab1.common.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.databinding.FragmentTabBarBinding
import com.example.mobile_hard_mad_lab1.databinding.FragmentTabBarSleepBinding


private const val SCREEN = "screen"

class TabBarSleepFragment : Fragment() {
    private var screen: Int? = null
    private lateinit var binding : FragmentTabBarSleepBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            screen = it.getInt(SCREEN)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTabBarSleepBinding.inflate(inflater, container, false)

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(screen: Int) =
            TabBarSleepFragment().apply {
                arguments = Bundle().apply {
                    putInt(SCREEN, screen)
                }
            }
    }
}