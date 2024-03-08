package com.example.mobile_hard_mad_lab1.musicScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mobile_hard_mad_lab1.databinding.FragmentNightMusicBinding

class NightMusicFragment : Fragment() {
    private lateinit var binding: FragmentNightMusicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNightMusicBinding.inflate(inflater, container, false)

        val navController = findNavController()
        val cancelButton = binding.cancelButtonImageView

        cancelButton.setOnClickListener {
            navController.navigateUp()
        }

        return binding.root
    }
}