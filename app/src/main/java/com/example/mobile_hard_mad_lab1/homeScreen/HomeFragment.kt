package com.example.mobile_hard_mad_lab1.homeScreen

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
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

        val recyclerView = binding.recyclerView
        val viewManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val viewApapter = HomeAdapter(recommendationService.generateRecommendations())

        recyclerView.apply {
            layoutManager = viewManager
            adapter = viewApapter
        }

        return binding.root
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