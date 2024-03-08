package com.example.mobile_hard_mad_lab1.sleepScreen.service

import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.sleepScreen.model.CategorySleep

class CategorySleepService {
    private val all = "All"
    private val my = "My"
    private val anxious = "Anxious"
    private val sleep = "Sleep"
    private val kids = "Kids"
    private val recent = "Recent"

    fun generateCategories() =
        arrayOf(
            CategorySleep(
                name = all,
                icon = R.drawable.category_all_icon,
                isSelected = true
            ),
            CategorySleep(
                name = my,
                icon = R.drawable.category_my_icon,
                isSelected = false
            ),
            CategorySleep(
                name = anxious,
                icon = R.drawable.category_anxious_icon,
                isSelected = false
            ),
            CategorySleep(
                name = sleep,
                icon = R.drawable.category_sleep_icon,
                isSelected = false
            ),
            CategorySleep(
                name = kids,
                icon = R.drawable.category_kids_icon,
                isSelected = false
            ),
            CategorySleep(
                name = recent,
                icon = R.drawable.category_all_icon,
                isSelected = false
            )
        )
}