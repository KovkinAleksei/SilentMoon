package com.example.mobile_hard_mad_lab1.playOptionScreen

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.WindowInsetsCompat
import com.example.mobile_hard_mad_lab1.common.MarginFix
import com.example.mobile_hard_mad_lab1.databinding.FragmentPlayOptionBinding

class PlayOptionFragment : Fragment() {
    private lateinit var binding : FragmentPlayOptionBinding
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

        return binding.root
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