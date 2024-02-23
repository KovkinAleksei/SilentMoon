package com.example.mobile_hard_mad_lab1.chooseTopicScreen.service

import android.graphics.Color
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.chooseTopicScreen.model.TopicCard

class ChooseTopicService {
    fun getTopicCards() : Array<TopicCard> = arrayOf(
        TopicCard(
            name = "Reduce stress",
            imageResource = R.drawable.reduce_stress_bg,
            textColor = Color.parseColor("#FFECCC")
        ),
        TopicCard(
            name = "Improve Performance",
            imageResource = R.drawable.improve_performance_bg,
            textColor = Color.parseColor("#FEF9F3")
        ),
        TopicCard(
            name = "Increase Happiness",
            imageResource = R.drawable.increase_happiness_bg,
            textColor = Color.parseColor("#3F414E")
        ),
        TopicCard(
            name = "Reduce Anxiety",
            imageResource = R.drawable.reduce_anxiety_bg,
            textColor = Color.parseColor("#3F414E")
        ),
        TopicCard(
            name = "Personal Growth",
            imageResource = R.drawable.personal_growth_bg,
            textColor = Color.parseColor("#FFECCC")
        ),
        TopicCard(
            name = "Better Sleep",
            imageResource = R.drawable.better_sleep_bg,
            textColor = Color.parseColor("#EBEAEC")
        ),
        TopicCard(
            name = "Relax",
            imageResource = R.drawable.relax_bg,
            textColor = Color.parseColor("#FEF9F3")
        ),
        TopicCard(
            name = "Improve focus",
            imageResource = R.drawable.improve_focus_bg,
            textColor = Color.parseColor("#FEF9F3")
        )
    )
}