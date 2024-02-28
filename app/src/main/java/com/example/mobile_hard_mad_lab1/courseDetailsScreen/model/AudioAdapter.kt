package com.example.mobile_hard_mad_lab1.courseDetailsScreen.model

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.databinding.AudioRowBinding

class AudioAdapter(
    private var audioArray: Array<String>
) : RecyclerView.Adapter<AudioAdapter.AudioViewHolder>() {

    override fun getItemCount() = audioArray.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AudioRowBinding.inflate(inflater, parent, false)

        return AudioViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AudioViewHolder, position: Int) {
        val audioName = holder.itemView.findViewById<TextView>(R.id.audioNameTextView)
        audioName.text = audioArray[position]
    }

    class AudioViewHolder(binding: AudioRowBinding) : RecyclerView.ViewHolder(binding.root)
}