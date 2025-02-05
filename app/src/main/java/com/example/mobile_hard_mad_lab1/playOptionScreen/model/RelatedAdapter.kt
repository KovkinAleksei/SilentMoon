package com.example.mobile_hard_mad_lab1.playOptionScreen.model

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.databinding.RelatedElementBinding

class RelatedAdapter(
    private var relations: Array<RelatedStory>
) : RecyclerView.Adapter<RelatedAdapter.RelatedViewHolder>() {

    override fun getItemCount() = relations.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RelatedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RelatedElementBinding.inflate(inflater, parent, false)

        return RelatedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RelatedViewHolder, position: Int) {
        val storyName = holder.itemView.findViewById<TextView>(R.id.storyName)
        storyName.text = relations[position].name

        val storyImage = holder.itemView.findViewById<ImageView>(R.id.storyImage)
        storyImage.setImageResource(relations[position].image)
    }

    class RelatedViewHolder(binding: RelatedElementBinding) : RecyclerView.ViewHolder(binding.root)
}