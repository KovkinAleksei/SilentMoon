package com.example.mobile_hard_mad_lab1.meditateScreen.service

import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.meditateScreen.model.MeditationImage

class MeditationImageService {
    private val daysOfCalm = "7 Days of Calm"
    private val anxietyRelease = "Anxiety Release"
    private val dailyThought = "Daily Thought"
    private val dailyCalm = "Daily Calm"

    fun generateMeditationImages() =
        arrayOf(
            MeditationImage(
                title = daysOfCalm,
                imageRes = R.drawable.days_of_calm_bg,
                height = 210
            ),
            MeditationImage(
                title = anxietyRelease,
                imageRes = R.drawable.anxiety_release_bg,
                height = 167
            ),
            MeditationImage(
                title = dailyThought,
                imageRes = R.drawable.daily_thought_image,
                height = 210
            ),
            MeditationImage(
                title = dailyCalm,
                imageRes = R.drawable.daily_calm_image,
                height = 167
            )
        )
}