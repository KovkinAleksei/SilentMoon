package com.example.mobile_hard_mad_lab1.courseDetailsScreen

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.chooseTopicScreen.model.ChooseTopicAdapter
import com.example.mobile_hard_mad_lab1.common.MarginFix
import com.example.mobile_hard_mad_lab1.courseDetailsScreen.model.AudioAdapter
import com.example.mobile_hard_mad_lab1.databinding.FragmentCourseDetailsBinding

class CourseDetailsFragment : Fragment() {
    private lateinit var binding : FragmentCourseDetailsBinding
    private var marginIsFixed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCourseDetailsBinding.inflate(inflater, container, false)

        fixMargins(container)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.audioRecyclerView
        val viewManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val viewAdapter = AudioAdapter(
            arrayOf("Focus Attention", "Body Scan", "Making Happiness", "Focus Attention",
                "Focus Attention", "Body Scan", "Making Happiness", "Focus Attention",
                "Focus Attention", "Body Scan", "Making Happiness", "Focus Attention")
        )

        recyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    // Выравнивание отступов относительно статус бара и системной навигационной панели
    @RequiresApi(Build.VERSION_CODES.R)
    private fun fixMargins(container: ViewGroup?) {
        container?.setOnApplyWindowInsetsListener{v, insets ->
            val systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            if (!marginIsFixed) {

                marginIsFixed = true
            }

            insets
        }
    }
}