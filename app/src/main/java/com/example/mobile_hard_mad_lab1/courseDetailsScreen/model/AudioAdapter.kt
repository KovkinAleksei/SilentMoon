package com.example.mobile_hard_mad_lab1.courseDetailsScreen.model

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.databinding.AudioRowBinding

class AudioAdapter(
    private var audioArray: Array<Audio>
) : RecyclerView.Adapter<AudioAdapter.AudioViewHolder>() {

    override fun getItemCount() = audioArray.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AudioRowBinding.inflate(inflater, parent, false)

        return AudioViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AudioViewHolder, position: Int) {
        val audioName = holder.itemView.findViewById<TextView>(R.id.audioNameTextView)
        audioName.text = audioArray[position].name

        val audioDuration = holder.itemView.findViewById<TextView>(R.id.audioDurationTextView)
        audioDuration.text = "${audioArray[position].duration} MIN"

        val playImage = holder.itemView.findViewById<ImageView>(R.id.playImageView)
        playImage.setImageResource(
            if (audioArray[position].isSelected)
                R.drawable.selected_play_button
            else
                R.drawable.unselected_play_button
        )

        if (position == audioArray.size - 1) {
            val divider = holder.itemView.findViewById<View>(R.id.audioDividerView)
            divider.setBackgroundColor(Color.parseColor("#00000000"))
        }
    }

    class AudioViewHolder(binding: AudioRowBinding) : RecyclerView.ViewHolder(binding.root)
}