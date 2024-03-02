package com.example.mobile_hard_mad_lab1.courseDetailsScreen.service

import com.example.mobile_hard_mad_lab1.courseDetailsScreen.model.Audio

class AudioService {
    fun generateAudioArray() =
        arrayOf(
            Audio(
                name = "Focus Attention",
                duration = 10,
                isSelected = true
            ),
            Audio(
                name = "Body Scan",
                duration = 5,
                isSelected = false
            ),
            Audio(
                name = "Making Happiness",
                duration = 3,
                isSelected = false
            ),
            Audio(
                name = "Focus Attention",
                duration = 10,
                isSelected = false
            ),
            Audio(
                name = "Body Scan",
                duration = 5,
                isSelected = false
            ),
            Audio(
                name = "Making Happiness",
                duration = 3,
                isSelected = false
            ),
            Audio(
                name = "Focus Attention",
                duration = 10,
                isSelected = false
            ),
            Audio(
                name = "Body Scan",
                duration = 5,
                isSelected = false
            ),
            Audio(
                name = "Making Happiness",
                duration = 3,
                isSelected = false
            )
        )
}