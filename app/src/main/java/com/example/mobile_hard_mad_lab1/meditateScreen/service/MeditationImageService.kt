package com.example.mobile_hard_mad_lab1.meditateScreen.service

import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.meditateScreen.model.MeditationImage

class MeditationImageService {
    fun generateMeditationImages() =
        arrayOf(
            MeditationImage(
                title = "7 Days of Calm",
                imageRes = R.drawable.days_of_calm_bg,
                height = 210
            ),
            MeditationImage(
                title = "Anxiety Release",
                imageRes = R.drawable.anxiety_release_bg,
                height = 167
            ),
            MeditationImage(
                title = "Daily Thought",
                imageRes = R.drawable.daily_thought_image,
                height = 210
            ),
            MeditationImage(
                title = "Daily Calm",
                imageRes = R.drawable.daily_calm_image,
                height = 167
            )
        )
}