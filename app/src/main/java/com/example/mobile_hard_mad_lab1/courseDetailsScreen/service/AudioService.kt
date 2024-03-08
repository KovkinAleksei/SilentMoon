package com.example.mobile_hard_mad_lab1.courseDetailsScreen.service

import com.example.mobile_hard_mad_lab1.courseDetailsScreen.model.Audio

class AudioService {
    private val focusAttention = "Focus Attention"
    private val bodyScan = "Body Scan"
    private val makingHappiness = "Making Happiness"

    fun generateAudioArray() =
        arrayOf(
            Audio(
                name = focusAttention,
                duration = 10,
                isSelected = true
            ),
            Audio(
                name = bodyScan,
                duration = 5,
                isSelected = false
            ),
            Audio(
                name = makingHappiness,
                duration = 3,
                isSelected = false
            ),
            Audio(
                name = focusAttention,
                duration = 10,
                isSelected = false
            ),
            Audio(
                name = bodyScan,
                duration = 5,
                isSelected = false
            ),
            Audio(
                name = makingHappiness,
                duration = 3,
                isSelected = false
            ),
            Audio(
                name = focusAttention,
                duration = 10,
                isSelected = false
            ),
            Audio(
                name = bodyScan,
                duration = 5,
                isSelected = false
            ),
            Audio(
                name = makingHappiness,
                duration = 3,
                isSelected = false
            )
        )
}