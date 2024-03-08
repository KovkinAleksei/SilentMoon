package com.example.mobile_hard_mad_lab1.meditateScreen

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.common.MarginFix
import com.example.mobile_hard_mad_lab1.common.fragments.TabBarFragment
import com.example.mobile_hard_mad_lab1.databinding.FragmentMeditateBinding
import com.example.mobile_hard_mad_lab1.meditateScreen.model.CategoryAdapter
import com.example.mobile_hard_mad_lab1.meditateScreen.model.MeditationImageAdapter
import com.example.mobile_hard_mad_lab1.meditateScreen.service.CategoryService
import com.example.mobile_hard_mad_lab1.meditateScreen.service.MeditationImageService


class MeditateFragment : Fragment() {
    private lateinit var binding: FragmentMeditateBinding
    private val categoryService = CategoryService()
    private val meditationImageService = MeditationImageService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMeditateBinding.inflate(inflater, container, false)
        fixMargins(container)

        // Recycler View для категорий
        val categoryRecyclerView = binding.categoryRecyclerView
        val viewManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val viewAdapter = CategoryAdapter(categoryService.generateCategories())

        categoryRecyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        // Recycler View для картинок
        val imageRecyclerView = binding.imagesRecyclerView
        val imageViewManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val imageViewAdapter =
            MeditationImageAdapter(meditationImageService.generateMeditationImages())

        imageRecyclerView.apply {
            layoutManager = imageViewManager
            adapter = imageViewAdapter
        }

        // Добавление Tab Bar в разметку
        val tabBarFragment = TabBarFragment.newInstance(R.id.meditateFragment)
        parentFragmentManager.beginTransaction().replace(R.id.tabBarLayout, tabBarFragment).commit()

        return binding.root
    }

    // Выравнивание отступов относительно статус бара и системной навигационной панели
    @RequiresApi(Build.VERSION_CODES.R)
    private fun fixMargins(container: ViewGroup?) {
        container?.setOnApplyWindowInsetsListener { v, insets ->
            val windowInsets = ViewCompat.getRootWindowInsets(v)
            val systemInsets = windowInsets?.getInsets(WindowInsetsCompat.Type.systemBars())

            val meditateTextView = binding.meditateTextView
            MarginFix.addTopMargin(meditateTextView, systemInsets)

            insets
        }
    }
}