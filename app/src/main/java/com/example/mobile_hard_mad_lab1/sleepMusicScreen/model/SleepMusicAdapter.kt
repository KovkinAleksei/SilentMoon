package com.example.mobile_hard_mad_lab1.sleepMusicScreen.model

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.databinding.RelatedElementBinding

class SleepMusicAdapter(
    private val music: Array<SleepMusic>,
    private val onClick: () -> Unit
) : RecyclerView.Adapter<SleepMusicAdapter.SleepMusicViewHolder>() {
    override fun getItemCount() = music.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepMusicViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RelatedElementBinding.inflate(inflater, parent, false)

        return SleepMusicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SleepMusicViewHolder, position: Int) {
        val storyName = holder.itemView.findViewById<TextView>(R.id.storyName)
        storyName.text = music[position].name

        val storyImage = holder.itemView.findViewById<ImageView>(R.id.storyImage)
        storyImage.setImageResource(music[position].image)

        storyName.setOnClickListener {
            onClick()
        }

        storyImage.setOnClickListener {
            onClick()
        }
    }

    class SleepMusicViewHolder(binding: RelatedElementBinding) :
        RecyclerView.ViewHolder(binding.root)
}