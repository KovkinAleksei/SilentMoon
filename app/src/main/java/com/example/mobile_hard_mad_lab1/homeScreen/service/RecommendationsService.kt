package com.example.mobile_hard_mad_lab1.homeScreen.service

import android.graphics.Color
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.homeScreen.model.RecommendationCard

class RecommendationsService {
    private val focus = "Focus"
    private val happiness = "Happiness"

    private val focusColor = "#AFDBC5"
    private val happinessColor = "#FEE3B4"

    fun generateRecommendations(): Array<RecommendationCard> {
        return arrayOf(
            RecommendationCard(
                name = focus,
                imageResource = R.drawable.focus_bg,
                bgColor = Color.parseColor(focusColor)
            ),
            RecommendationCard(
                name = happiness,
                imageResource = R.drawable.happiness_bg,
                bgColor = Color.parseColor(happinessColor)
            ),
            RecommendationCard(
                name = focus,
                imageResource = R.drawable.focus_bg,
                bgColor = Color.parseColor(focusColor)
            )
        )
    }
}