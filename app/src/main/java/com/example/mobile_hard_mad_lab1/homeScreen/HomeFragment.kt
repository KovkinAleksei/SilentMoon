package com.example.mobile_hard_mad_lab1.homeScreen

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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.common.MarginFix
import com.example.mobile_hard_mad_lab1.common.fragments.TabBarFragment
import com.example.mobile_hard_mad_lab1.databinding.FragmentHomeBinding
import com.example.mobile_hard_mad_lab1.homeScreen.model.HomeAdapter
import com.example.mobile_hard_mad_lab1.homeScreen.service.RecommendationsService

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val recommendationService = RecommendationsService()

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
        }

        val viewAdapter = HomeAdapter(
            recommendations = recommendationService.generateRecommendations(),
            onCardClick = onRecommendationClick
        )

        recyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        // Добавление Tab Bar в разметку
        parentFragmentManager.beginTransaction().replace(R.id.tabBarLayout, TabBarFragment())
            .commit()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        val basicsCourse = binding.basicsCourseButton
        val relaxationMusic = binding.relaxationMusicButton

        basicsCourse.setOnClickListener {
            navController.navigate(R.id.courseDetailsFragment)
        }

        relaxationMusic.setOnClickListener {
            navController.navigate(R.id.courseDetailsFragment)
        }
    }

    // Выравнивание отступов относительно статус бара и системной навигационной панели
    @RequiresApi(Build.VERSION_CODES.R)
    private fun fixMargins(container: ViewGroup?) {
        container?.setOnApplyWindowInsetsListener { v, insets ->
            val windowInsets = ViewCompat.getRootWindowInsets(v)
            val systemInsets = windowInsets?.getInsets(WindowInsetsCompat.Type.systemBars())

            val scrollView = binding.scrollView2
            MarginFix.addTopMargin(scrollView, systemInsets)

            insets
        }
    }
}