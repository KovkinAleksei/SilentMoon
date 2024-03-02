package com.example.mobile_hard_mad_lab1.playOptionScreen.model

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginBottom
import androidx.core.view.marginEnd
import androidx.core.view.marginStart
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.databinding.RelatedElementBinding

class RelatedAdapter(
    private var relations : Array<String>
) : RecyclerView.Adapter<RelatedAdapter.RelatedViewHolder>() {

    override fun getItemCount() = relations.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RelatedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RelatedElementBinding.inflate(inflater, parent, false)

        return RelatedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RelatedViewHolder, position: Int) {
        val storyName = holder.itemView.findViewById<TextView>(R.id.storyName)
        storyName.text = relations[position]

        val relatedLayout = holder.itemView.findViewById<ConstraintLayout>(R.id.relatedStoryLayout)
        val margin = (20 * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

        relatedLayout.post {
            val halfWidth = (relatedLayout.width - margin) / 2// - margin
            val layoutParams = relatedLayout.layoutParams as RecyclerView.LayoutParams
            layoutParams.width = halfWidth

            relatedLayout.layoutParams = layoutParams
        }

        val params = relatedLayout.layoutParams as ViewGroup.MarginLayoutParams
        params.setMargins(0, 0, margin, 0)
    }

    class RelatedViewHolder(binding: RelatedElementBinding) : RecyclerView.ViewHolder(binding.root)
}