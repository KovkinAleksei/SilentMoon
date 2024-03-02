package com.example.mobile_hard_mad_lab1.musicScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mobile_hard_mad_lab1.databinding.FragmentMusicBinding


class MusicFragment : Fragment() {
    private lateinit var binding : FragmentMusicBinding
    private var marginIsFixed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMusicBinding.inflate(inflater, container, false)

        return binding.root
    }
}