package com.example.mobile_hard_mad_lab1.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.databinding.TopicCardBinding

class ChooseTopicAdapter(
    private val topicsList: Array<String>
) : RecyclerView.Adapter<ChooseTopicAdapter.ChooseTopicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChooseTopicViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TopicCardBinding.inflate(inflater, parent, false)

        return ChooseTopicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChooseTopicViewHolder, position: Int) {
        val topicName = holder.itemView.findViewById<TextView>(R.id.topicName)
        topicName.text = topicsList[position]

        val topicBg = holder.itemView.findViewById<ImageView>(R.id.topicBg)

        if (position % 2 != 0)
            topicBg.setImageResource(R.drawable.improve_performance_bg)
    }

    override fun getItemCount() = topicsList.size

    class ChooseTopicViewHolder(binding: TopicCardBinding) : RecyclerView.ViewHolder(binding.root)
}