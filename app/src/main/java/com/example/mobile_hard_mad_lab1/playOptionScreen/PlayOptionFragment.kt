package com.example.mobile_hard_mad_lab1.playOptionScreen

import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginBottom
import androidx.core.view.marginEnd
import androidx.core.view.marginStart
import androidx.core.view.marginTop
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.common.MarginFix
import com.example.mobile_hard_mad_lab1.databinding.FragmentPlayOptionBinding
import com.example.mobile_hard_mad_lab1.playOptionScreen.model.RelatedAdapter
import com.example.mobile_hard_mad_lab1.playOptionScreen.service.RelatedStoryService

class PlayOptionFragment : Fragment() {
    private lateinit var binding : FragmentPlayOptionBinding
    private val relatedStoryService = RelatedStoryService()
    private var marginIsFixed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlayOptionBinding.inflate(inflater, container, false)
        fixMargins(container)

        val navController = findNavController()
        val backButton = binding.backButton

        backButton.setOnClickListener {
            navController.navigateUp()
            marginIsFixed = false
        }

        binding.playButton.setOnClickListener {
            marginIsFixed = false
            navController.navigate(R.id.nightMusicFragment)
        }

        val recyclerView = binding.relatedRecyclerView
        val viewManager = GridLayoutManager(context, 2)
        val viewAdapter = RelatedAdapter(relatedStoryService.generateRelatedStories())

        recyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        return binding.root
    }

    // Выравнивание отступов относительно статус бара и системной навигационной панели
    @RequiresApi(Build.VERSION_CODES.R)
    private fun fixMargins(container: ViewGroup?) {
        container?.setOnApplyWindowInsetsListener{v, insets ->
            val windowInsets = ViewCompat.getRootWindowInsets(v)
            val systemInsets = windowInsets?.getInsets(WindowInsetsCompat.Type.systemBars())
            val playButton = binding.playButton
            val recyclerView = binding.relatedRecyclerView

            if (!marginIsFixed) {
                if (systemInsets!!.bottom != 0) {
                    val bottomInset = (10 * Resources.getSystem().displayMetrics.density + 0.5f).toInt()
                    val params = playButton.layoutParams as ViewGroup.MarginLayoutParams
                    params.setMargins(playButton.marginStart, playButton.marginTop, playButton.marginEnd, playButton.marginBottom + bottomInset)

                    val recyclerParams = recyclerView.layoutParams as ViewGroup.MarginLayoutParams
                    recyclerParams.setMargins(recyclerView.marginStart, recyclerView.marginTop, recyclerView.marginEnd, recyclerView.marginBottom + bottomInset)
                }

                marginIsFixed = true
            }

            insets
        }
    }
}