package com.example.mobile_hard_mad_lab1.homeScreen.service

import android.graphics.Color
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.homeScreen.model.RecommendationCard

class RecommendatoinsService {
    fun generateRecommendations() : Array<RecommendationCard> {
        return arrayOf(
            RecommendationCard(
                name = "Focus",
                imageResource = R.drawable.focus_bg,
                bgColor = Color.parseColor("#AFDBC5")
            ),
            RecommendationCard(
                name = "Happiness",
                imageResource = R.drawable.happiness_bg,
                bgColor = Color.parseColor("#FEE3B4")
            ),
            RecommendationCard(
                name = "Focus",
                imageResource = R.drawable.focus_bg,
                bgColor = Color.parseColor("#AFDBC5")
            ),
        )
    }
}