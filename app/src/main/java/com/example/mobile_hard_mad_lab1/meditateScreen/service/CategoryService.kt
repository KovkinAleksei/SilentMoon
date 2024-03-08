package com.example.mobile_hard_mad_lab1.meditateScreen.service

import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.meditateScreen.model.Category

class CategoryService {
    private val all = "All"
    private val my = "My"
    private val anxious = "Anxious"
    private val sleep = "Sleep"
    private val kids = "Kids"
    private val recent = "Recent"

    fun generateCategories() =
        arrayOf(
            Category(
                name = all,
                icon = R.drawable.category_all_icon,
                isSelected = true
            ),
            Category(
                name = my,
                icon = R.drawable.category_my_icon,
                isSelected = false
            ),
            Category(
                name = anxious,
                icon = R.drawable.category_anxious_icon,
                isSelected = false
            ),
            Category(
                name = sleep,
                icon = R.drawable.category_sleep_icon,
                isSelected = false
            ),
            Category(
                name = kids,
                icon = R.drawable.category_kids_icon,
                isSelected = false
            ),
            Category(
                name = recent,
                icon = R.drawable.category_all_icon,
                isSelected = false
            ),
        )
}