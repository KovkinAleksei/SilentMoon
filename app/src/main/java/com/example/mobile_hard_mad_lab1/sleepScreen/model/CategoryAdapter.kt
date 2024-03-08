package com.example.mobile_hard_mad_lab1.sleepScreen.model

import android.content.res.Resources
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginBottom
import androidx.core.view.marginEnd
import androidx.core.view.marginStart
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.databinding.CategoryElementBinding

class CategoryAdapter(
    private var categories: Array<CategorySleep>
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun getItemCount() = categories.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CategoryElementBinding.inflate(inflater, parent, false)

        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val categoryName = holder.itemView.findViewById<TextView>(R.id.categoryNameTextView)
        categoryName.text = categories[position].name

        val icon = holder.itemView.findViewById<ImageView>(R.id.categoryIcon)
        icon.setImageResource(categories[position].icon)

        val categoryBg = holder.itemView.findViewById<View>(R.id.categoryBg)

        if (categories[position].isSelected) {
            categoryBg.background.setTint(Color.parseColor("#8E97FD"))
            categoryName.setTextColor(Color.parseColor("#E6E7F2"))
        } else {
            categoryBg.background.setTint(Color.parseColor("#586894"))
            categoryName.setTextColor(Color.parseColor("#98A1BD"))
        }

        if (position == 0) {
            val view = holder.itemView.findViewById<ConstraintLayout>(R.id.categoryConstraintLayout)
            val params = view.layoutParams as ViewGroup.MarginLayoutParams
            val startMargin = (20 * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

            params.setMargins(
                view.marginStart + startMargin,
                view.marginTop,
                view.marginEnd,
                view.marginBottom
            )
        }
    }

    class CategoryViewHolder(binding: CategoryElementBinding) :
        RecyclerView.ViewHolder(binding.root)
}