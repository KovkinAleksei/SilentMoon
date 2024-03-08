package com.example.mobile_hard_mad_lab1.common.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.databinding.FragmentTabBarSleepBinding

private const val SELECTED_SCREEN = "selected_screen"

class TabBarSleepFragment : Fragment() {
    private lateinit var binding : FragmentTabBarSleepBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            it.getInt(SELECTED_SCREEN)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTabBarSleepBinding.inflate(inflater, container, false)

        val musicTabBar = binding.tabBarMusic
        val navController = findNavController()

        musicTabBar.setOnClickListener {
            navController.navigate(R.id.nightMusicFragment)
        }

        if (arguments?.getInt(SELECTED_SCREEN) == R.id.sleepFragment){
            binding.tabBarMeditate.setOnClickListener {
                navController.navigate(R.id.action_sleepFragment_to_meditateFragment)
            }

            binding.tabBarHome.setOnClickListener {
                navController.navigate(R.id.action_sleepFragment_to_homeFragment)
            }
        }
        else if (arguments?.getInt(SELECTED_SCREEN) == R.id.sleepMusicFragment){
            binding.tabBarMeditate.setOnClickListener {
                navController.navigate(R.id.action_sleepMusicFragment_to_meditateFragment)
            }

            binding.tabBarHome.setOnClickListener {
                navController.navigate(R.id.action_sleepMusicFragment_to_homeFragment)
            }
        }


        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(screen: Int) =
            TabBarSleepFragment().apply {
                arguments = Bundle().apply {
                    putInt(SELECTED_SCREEN, screen)
                }
            }
    }
}