package com.example.mobile_hard_mad_lab1.musicV2Screen

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
import com.example.mobile_hard_mad_lab1.common.MarginFix
import com.example.mobile_hard_mad_lab1.databinding.FragmentMusicBinding

class MusicFragment : Fragment() {
    private lateinit var binding: FragmentMusicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMusicBinding.inflate(inflater, container, false)
        fixMargins(container)

        val navController = findNavController()
        val cancelButton = binding.cancelButton

        cancelButton.setOnClickListener {
            navController.navigateUp()
        }

        return binding.root
    }

    // Выравнивание отступов относительно статус бара и системной навигационной панели
    @RequiresApi(Build.VERSION_CODES.R)
    private fun fixMargins(container: ViewGroup?) {
        container?.setOnApplyWindowInsetsListener { v, insets ->
            val windowInsets = ViewCompat.getRootWindowInsets(v)
            val systemInsets = windowInsets?.getInsets(WindowInsetsCompat.Type.systemBars())
            val cancelButton = binding.cancelButton

            MarginFix.addTopMargin(cancelButton, systemInsets)

            insets
        }
    }
}