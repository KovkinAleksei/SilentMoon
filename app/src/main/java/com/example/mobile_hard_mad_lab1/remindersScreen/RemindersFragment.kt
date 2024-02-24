package com.example.mobile_hard_mad_lab1.remindersScreen

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.WindowInsetsCompat
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.common.MarginFix
import com.example.mobile_hard_mad_lab1.databinding.FragmentRemindersBinding


class RemindersFragment : Fragment() {
    private lateinit var binding: FragmentRemindersBinding
    private var marginIsFixed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRemindersBinding.inflate(inflater, container, false)
        fixMargins(container)

        return binding.root
    }

    // Выравнивание отступов относительно статус бара и системной навигационной панели
    @RequiresApi(Build.VERSION_CODES.R)
    private fun fixMargins(container: ViewGroup?) {
        container?.setOnApplyWindowInsetsListener{v, insets ->
            val systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            val timeTextView = binding.timeTextView

            if (!marginIsFixed) {
                MarginFix.addTopMargin(timeTextView, systemInsets)

                marginIsFixed = true
            }

            insets
        }
    }
}