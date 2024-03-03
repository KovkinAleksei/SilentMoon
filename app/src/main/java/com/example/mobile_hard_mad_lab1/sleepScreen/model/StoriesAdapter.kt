package com.example.mobile_hard_mad_lab1.sleepScreen.model

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.databinding.StoryElementBinding

class StoriesAdapter(
    private var stories : Array<SleepStory>,
    private var onClick : () -> Unit
) : RecyclerView.Adapter<StoriesAdapter.StoriesViewHolder>() {

    override fun getItemCount() = stories.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = StoryElementBinding.inflate(inflater, parent, false)

        return StoriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {
        val storyName = holder.itemView.findViewById<TextView>(R.id.storyName)
        storyName.text = stories[position].name

        val storyImage = holder.itemView.findViewById<ImageView>(R.id.storyImage)
        storyImage.setImageResource(stories[position].image)

        storyImage.setOnClickListener {
            onClick()
        }

        storyName.setOnClickListener {
            onClick()
        }
    }

    class StoriesViewHolder(binding : StoryElementBinding) : RecyclerView.ViewHolder(binding.root)
}