package com.example.mobile_hard_mad_lab1.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mobile_hard_mad_lab1.Adapter.ChooseTopicAdapter
import com.example.mobile_hard_mad_lab1.common.MarginFix
import com.example.mobile_hard_mad_lab1.databinding.FragmentChooseTopicBinding

class ChooseTopicFragment : Fragment() {
    private lateinit var binding : FragmentChooseTopicBinding
    private var marginIsFixed : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChooseTopicBinding.inflate(inflater, container, false)
        fixMargins(container)

        val recyclerView = binding.recyclerView
        val viewManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val viewAdaper = ChooseTopicAdapter(arrayOf("asdf", "fdsa", "tttt", "uu"))

        recyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdaper
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    // Выравнивание отступов относительно статус бара и системной навигационной панели
    @RequiresApi(Build.VERSION_CODES.R)
    private fun fixMargins(container: ViewGroup?) {
        container?.setOnApplyWindowInsetsListener{v, insets ->
            val systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            val questionTextView = binding.questionTextView

            if (!marginIsFixed) {
                MarginFix.addTopMargin(questionTextView, systemInsets)

                marginIsFixed = true
            }

            insets
        }
    }
}