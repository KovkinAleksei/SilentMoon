package com.example.mobile_hard_mad_lab1.homeScreen.model

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.databinding.RecommendationCardBinding

class HomeAdapter(
    private val recommendations: Array<String>
) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    override fun getItemCount() = recommendations.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecommendationCardBinding.inflate(inflater, parent, false)

        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val recommendation = holder.itemView.findViewById<TextView>(R.id.recommendationName)
        recommendation.text = recommendations[position]
    }

    class HomeViewHolder(binding: RecommendationCardBinding) : RecyclerView.ViewHolder(binding.root)
}