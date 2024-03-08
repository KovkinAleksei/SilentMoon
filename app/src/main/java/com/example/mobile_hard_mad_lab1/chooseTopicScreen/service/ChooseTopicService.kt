package com.example.mobile_hard_mad_lab1.chooseTopicScreen.service

import android.graphics.Color
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.chooseTopicScreen.model.TopicCard

class ChooseTopicService {
    private val reduceStress = "Reduce stress"
    private val improvePerformance = "Improve Performance"
    private val increaseHappiness = "Increase Happiness"
    private val reduceAnxiety = "Reduce Anxiety"
    private val personalGrowth = "Personal Growth"
    private val betterSleep = "Better Sleep"
    private val relax = "Relax"
    private val improveFocus = "Improve focus"

    private val firstColor = "#FFECCC"
    private val secondColor = "#FEF9F3"
    private val thirdColor = "#3F414E"
    private val fourthColor = "#EBEAEC"

    fun getTopicCards() : Array<TopicCard> = arrayOf(
        TopicCard(
            name = reduceStress,
            imageResource = R.drawable.reduce_stress_bg,
            textColor = Color.parseColor(firstColor)
        ),
        TopicCard(
            name = improvePerformance,
            imageResource = R.drawable.improve_performance_bg,
            textColor = Color.parseColor(secondColor)
        ),
        TopicCard(
            name = increaseHappiness,
            imageResource = R.drawable.increase_happiness_bg,
            textColor = Color.parseColor(thirdColor)
        ),
        TopicCard(
            name = reduceAnxiety,
            imageResource = R.drawable.reduce_anxiety_bg,
            textColor = Color.parseColor(thirdColor)
        ),
        TopicCard(
            name = personalGrowth,
            imageResource = R.drawable.personal_growth_bg,
            textColor = Color.parseColor(firstColor)
        ),
        TopicCard(
            name = betterSleep,
            imageResource = R.drawable.better_sleep_bg,
            textColor = Color.parseColor(fourthColor)
        ),
        TopicCard(
            name = relax,
            imageResource = R.drawable.relax_bg,
            textColor = Color.parseColor(secondColor)
        ),
        TopicCard(
            name = improveFocus,
            imageResource = R.drawable.improve_focus_bg,
            textColor = Color.parseColor(secondColor)
        )
    )
}