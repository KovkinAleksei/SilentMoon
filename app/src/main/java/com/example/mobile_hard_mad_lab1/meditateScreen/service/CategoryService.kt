package com.example.mobile_hard_mad_lab1.meditateScreen.service

import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.meditateScreen.model.Category

class CategoryService {
    fun generateCategories() =
        arrayOf(
            Category(
                name = "All",
                icon = R.drawable.category_all_icon,
                isSelected = true
            ),
            Category(
                name = "My",
                icon = R.drawable.category_my_icon,
                isSelected = false
            ),
            Category(
                name = "Anxious",
                icon = R.drawable.category_anxious_icon,
                isSelected = false
            ),
            Category(
                name = "Sleep",
                icon = R.drawable.category_sleep_icon,
                isSelected = false
            ),
            Category(
                name = "Kids",
                icon = R.drawable.category_kids_icon,
                isSelected = false
            ),
            Category(
                name = "Recent",
                icon = R.drawable.category_all_icon,
                isSelected = false
            ),
        )
}