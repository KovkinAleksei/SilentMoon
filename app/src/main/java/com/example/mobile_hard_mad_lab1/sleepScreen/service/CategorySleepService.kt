package com.example.mobile_hard_mad_lab1.sleepScreen.service

import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.sleepScreen.model.CategorySleep

class CategorySleepService {
    fun generateCategories() =
        arrayOf(
            CategorySleep(
                name = "All",
                icon = R.drawable.category_all_icon,
                isSelected = true
            ),
            CategorySleep(
                name = "My",
                icon = R.drawable.category_my_icon,
                isSelected = false
            ),
            CategorySleep(
                name = "Anxious",
                icon = R.drawable.category_anxious_icon,
                isSelected = false
            ),
            CategorySleep(
                name = "Sleep",
                icon = R.drawable.category_sleep_icon,
                isSelected = false
            ),
            CategorySleep(
                name = "Kids",
                icon = R.drawable.category_kids_icon,
                isSelected = false
            ),
            CategorySleep(
                name = "Recent",
                icon = R.drawable.category_all_icon,
                isSelected = false
            )
        )
}