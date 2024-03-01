package com.example.mobile_hard_mad_lab1.common.fragments

import android.graphics.Color
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
import com.example.mobile_hard_mad_lab1.databinding.FragmentTabBarBinding

private const val SELECTED_SCREEN = "selected_screen"

class TabBarFragment : Fragment() {
    private lateinit var binding : FragmentTabBarBinding
    private var marginIsFixed = false
    private val selectedScreen : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            it.getInt(SELECTED_SCREEN)
        }
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTabBarBinding.inflate(inflater, container, false)
        fixMargins(container)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val navController = findNavController()
        val meditateButton = binding.meditateTabBar

        if (arguments?.getInt(SELECTED_SCREEN) != R.id.meditateFragment)
            meditateButton.setOnClickListener {
                navController.navigate(R.id.action_homeFragment_to_meditateFragment)
                marginIsFixed = false
            }
        else if (arguments?.getInt(SELECTED_SCREEN) != R.id.homeFragment) {
            val meditateBg = binding.meditateBg
            meditateBg.background.setTint(Color.parseColor("#8E97FD"))

            val meditateIcom = binding.meditateTabBarImage
            meditateIcom.setImageResource(R.drawable.selected_meditate_tab_bar)

            val homeIcon = binding.homeTabBarIcon
            homeIcon.setImageResource(R.drawable.unselected_home_tab_bar)

            val homeBg = binding.homeBg
            homeBg.background.setTint(Color.parseColor("#FFFFFF"))

            val homeText = binding.homeText
            homeText.setTextColor(Color.parseColor("#A0A3B1"))

            val meditateText = binding.meditateTabBarText
            meditateText.setTextColor(Color.parseColor("#8E97FD"))

            val homeTabBarButton = binding.homeTabBar

            homeTabBarButton.setOnClickListener {
                navController.navigate(R.id.action_meditateFragment_to_homeFragment)
                marginIsFixed = false
            }
        }
    }

    // Выравнивание отступов относительно статус бара и системной навигационной панели
    @RequiresApi(Build.VERSION_CODES.R)
    private fun fixMargins(container: ViewGroup?) {
        container?.setOnApplyWindowInsetsListener{v, insets ->
            val systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            val tabBar = binding.bottomNavBar

            if (!marginIsFixed) {
                MarginFix.addBottomMargin(tabBar, systemInsets)

                marginIsFixed = true
            }

            insets
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(screen: Int) =
            TabBarFragment().apply {
                arguments = Bundle().apply {
                    putInt(SELECTED_SCREEN, screen)
                }
            }
    }
}