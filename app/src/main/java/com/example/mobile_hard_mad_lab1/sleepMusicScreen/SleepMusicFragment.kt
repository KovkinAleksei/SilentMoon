package com.example.mobile_hard_mad_lab1.sleepMusicScreen

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.common.MarginFix
import com.example.mobile_hard_mad_lab1.common.fragments.TabBarSleepFragment
import com.example.mobile_hard_mad_lab1.databinding.FragmentSleepBinding
import com.example.mobile_hard_mad_lab1.databinding.FragmentSleepMusicBinding
import com.example.mobile_hard_mad_lab1.playOptionScreen.PlayOptionFragment
import com.example.mobile_hard_mad_lab1.sleepMusicScreen.model.SleepMusicAdapter
import com.example.mobile_hard_mad_lab1.sleepMusicScreen.service.SleepMusicService

class SleepMusicFragment : Fragment() {
    private lateinit var binding : FragmentSleepMusicBinding
    private val sleepMusicService = SleepMusicService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSleepMusicBinding.inflate(inflater, container, false)
        fixMargins(container)

        val tabBarSleepFragment = TabBarSleepFragment.newInstance(R.id.sleepMusicFragment)
        parentFragmentManager.beginTransaction().replace(R.id.tabBarLayout, tabBarSleepFragment).commit()

        val recyclerView = binding.recyclerView
        val viewManager = GridLayoutManager(context, 2)
        val navController = findNavController()

        val onSleepMusicClick = {
            navController.navigate(R.id.playOptionFragment)
        }

        val viewAdapter = SleepMusicAdapter(
            music = sleepMusicService.generateSleepMusic(),
            onClick = onSleepMusicClick
        )

        recyclerView.apply{
            layoutManager = viewManager
            adapter = viewAdapter
        }


        binding.backButtonImageView.setOnClickListener{
            navController.navigateUp()
        }

        return binding.root
    }

    // Выравнивание отступов относительно статус бара и системной навигационной панели
    @RequiresApi(Build.VERSION_CODES.R)
    private fun fixMargins(container: ViewGroup?) {
        container?.setOnApplyWindowInsetsListener{v, insets ->
            val systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            val tabBarLayout = binding.tabBarLayout

            MarginFix.addBottomMargin(tabBarLayout, systemInsets)

            insets
        }
    }
}