package com.example.mobile_hard_mad_lab1.sleepScreen

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.common.MarginFix
import com.example.mobile_hard_mad_lab1.common.fragments.ContinueMethodFragment
import com.example.mobile_hard_mad_lab1.common.fragments.TabBarFragment
import com.example.mobile_hard_mad_lab1.common.fragments.TabBarSleepFragment
import com.example.mobile_hard_mad_lab1.databinding.FragmentSleepBinding
import com.example.mobile_hard_mad_lab1.sleepScreen.model.CategoryAdapter
import com.example.mobile_hard_mad_lab1.sleepScreen.model.StoriesAdapter
import com.example.mobile_hard_mad_lab1.sleepScreen.service.CategorySleepService
import com.example.mobile_hard_mad_lab1.sleepScreen.service.StoryService

class SleepFragment : Fragment() {
    private lateinit var binding : FragmentSleepBinding
    private val categoryService = CategorySleepService()
    private val storyService = StoryService()
    private var marginIsFixed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSleepBinding.inflate(inflater, container, false)
        fixMargins(container)

        // Recycler View для категорий
        val categoryRecyclerView = binding.categoriesRecyclerView
        val viewManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val viewAdapter = CategoryAdapter(categoryService.generateCategories())

        categoryRecyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        // Recycler View для Sleep Stories
        val storiesRecyclerView = binding.storiesRecyclerView
        val storiesViewManager = GridLayoutManager(context, 2)
        val navController = findNavController()

        val onStoryClick = {
            navController.navigate(R.id.playOptionFragment)
            marginIsFixed = false
        }

        val storiesAdapter = StoriesAdapter(storyService.generateStories(), onStoryClick)

        storiesRecyclerView.apply {
            layoutManager = storiesViewManager
            adapter = storiesAdapter
        }

        val tabBar = TabBarSleepFragment.newInstance(R.id.sleepFragment)
        parentFragmentManager.beginTransaction().replace(R.id.tabBarLayout, tabBar).commit()

        val startButton = binding.startButton

        startButton.setOnClickListener {
            navController.navigate(R.id.sleepMusicFragment)
            marginIsFixed = false
        }

        return binding.root
    }

    // Выравнивание отступов относительно статус бара и системной навигационной панели
    @RequiresApi(Build.VERSION_CODES.R)
    private fun fixMargins(container: ViewGroup?) {
        container?.setOnApplyWindowInsetsListener{v, insets ->
            val systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            val sleepSky = binding.sleepSky
            val tabBar = binding.tabBarLayout

            if (!marginIsFixed) {
                MarginFix.addTopMargin(sleepSky, systemInsets)
                MarginFix.addBottomMargin(tabBar, systemInsets)

                marginIsFixed = true
            }

            insets
        }
    }
}