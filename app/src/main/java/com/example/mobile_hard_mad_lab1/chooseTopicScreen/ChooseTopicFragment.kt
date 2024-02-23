package com.example.mobile_hard_mad_lab1.chooseTopicScreen

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.chooseTopicScreen.model.ChooseTopicAdapter
import com.example.mobile_hard_mad_lab1.chooseTopicScreen.service.ChooseTopicService
import com.example.mobile_hard_mad_lab1.common.MarginFix
import com.example.mobile_hard_mad_lab1.databinding.FragmentChooseTopicBinding

class ChooseTopicFragment : Fragment() {
    private lateinit var binding : FragmentChooseTopicBinding
    private var marginIsFixed : Boolean = false
    private val chooseTopicService = ChooseTopicService()

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

        val navController = findNavController()
        val onClick = {
            navController.navigate(R.id.signInSignUpFragment2)
            marginIsFixed = false
        }

        val recyclerView = binding.recyclerView
        val viewManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val viewAdapter = ChooseTopicAdapter(
            topicsList = chooseTopicService.getTopicCards(),
            onClick = onClick
        )

        recyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
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