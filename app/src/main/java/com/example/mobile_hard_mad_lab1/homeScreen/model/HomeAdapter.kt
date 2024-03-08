package com.example.mobile_hard_mad_lab1.homeScreen.model

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.databinding.RecommendationCardBinding

class HomeAdapter(
    private val recommendations: Array<RecommendationCard>,
    private val onCardClick: () -> Unit
) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    override fun getItemCount() = recommendations.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecommendationCardBinding.inflate(inflater, parent, false)

        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val recommendation = holder.itemView.findViewById<TextView>(R.id.storyName)
        recommendation.text = recommendations[position].name

        val bgImage = holder.itemView.findViewById<ImageView>(R.id.storyImage)
        bgImage.setImageResource(recommendations[position].imageResource)

        val relatedLayout = holder.itemView.findViewById<ConstraintLayout>(R.id.relatedStoryLayout)
        val margin = (20 * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

        relatedLayout.post {
            val halfWidth = Math.ceil((relatedLayout.width - margin).toDouble() / 2).toInt()
            val layoutParams = relatedLayout.layoutParams as RecyclerView.LayoutParams
            layoutParams.width = halfWidth

            relatedLayout.layoutParams = layoutParams
        }

        val params = relatedLayout.layoutParams as ViewGroup.MarginLayoutParams
        params.setMargins(0, 0, margin, 0)

        val recommendationBg = holder.itemView.findViewById<View>(R.id.storyBg)

        recommendationBg.setOnClickListener {
            onCardClick()
        }
    }

    class HomeViewHolder(binding: RecommendationCardBinding) : RecyclerView.ViewHolder(binding.root)
}