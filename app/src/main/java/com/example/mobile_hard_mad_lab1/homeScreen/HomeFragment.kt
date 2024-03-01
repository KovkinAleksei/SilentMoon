package com.example.mobile_hard_mad_lab1.homeScreen

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.common.MarginFix
import com.example.mobile_hard_mad_lab1.databinding.FragmentHomeBinding
import com.example.mobile_hard_mad_lab1.homeScreen.model.HomeAdapter
import com.example.mobile_hard_mad_lab1.homeScreen.service.RecommendatoinsService

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    private var marginIsFixed = false
    private val recommendationService = RecommendatoinsService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        fixMargins(container)

        // Recycler View с рекомменациями
        val recyclerView = binding.recyclerView
        val viewManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val navController = findNavController()
        val onRecommendationClick = {
            navController.navigate(R.id.courseDetailsFragment)
            marginIsFixed = false
        }

        val viewAdapter = HomeAdapter(
            recommendations = recommendationService.generateRecommendations(),
            onCardClick = onRecommendationClick
        )

        recyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        // Навигация на Tab Bar
        val meditateTabBar = binding.meditateTabBar

        meditateTabBar.setOnClickListener {
            navController.navigate(R.id.meditateFragment)
            marginIsFixed = false
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        val basicsCourse = binding.basicsCourseButton
        val relaxationMusic = binding.relaxationMusicButton

        basicsCourse.setOnClickListener {
            navController.navigate(R.id.courseDetailsFragment)
            marginIsFixed = false
        }

        relaxationMusic.setOnClickListener {
            navController.navigate(R.id.courseDetailsFragment)
            marginIsFixed = false
        }
    }

    // Выравнивание отступов относительно статус бара и системной навигационной панели
    @RequiresApi(Build.VERSION_CODES.R)
    private fun fixMargins(container: ViewGroup?) {
        container?.setOnApplyWindowInsetsListener{v, insets ->
            val systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            val scrollView = binding.scrollView2
            val bottomNavBar = binding.bottomNavBar

            if (!marginIsFixed) {
                MarginFix.addTopMargin(scrollView, systemInsets)
                MarginFix.addBottomMargin(bottomNavBar, systemInsets)

                marginIsFixed = true
            }

            insets
        }
    }
}