package com.example.mobile_hard_mad_lab1.chooseTopicScreen.model

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.databinding.TopicCardBinding

class ChooseTopicAdapter(
    private val topicsList: Array<TopicCard>,
    val onClick: () -> Unit
) : RecyclerView.Adapter<ChooseTopicAdapter.ChooseTopicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChooseTopicViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TopicCardBinding.inflate(inflater, parent, false)

        return ChooseTopicViewHolder(binding)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ChooseTopicViewHolder, position: Int) {
        val topicName = holder.itemView.findViewById<TextView>(R.id.topicName)
        topicName.setTextColor(topicsList[position].textColor)
        topicName.text = topicsList[position].name

        val topicBg = holder.itemView.findViewById<ImageView>(R.id.topicBg)
        topicBg.setImageResource(topicsList[position].imageResource)

        holder.itemView.setOnClickListener {
            onClick()
        }
    }

    override fun getItemCount() = topicsList.size

    class ChooseTopicViewHolder(binding: TopicCardBinding) : RecyclerView.ViewHolder(binding.root)
}