package com.example.mobile_hard_mad_lab1.meditateScreen.model

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.databinding.MeditationImageElementBinding

class MeditationImageAdapter(
    private var meditationImages: Array<MeditationImage>
) : RecyclerView.Adapter<MeditationImageAdapter.MeditationImageViewHolder>() {

    override fun getItemCount() = meditationImages.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeditationImageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MeditationImageElementBinding.inflate(inflater, parent, false)

        return MeditationImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MeditationImageViewHolder, position: Int) {
        val title = holder.itemView.findViewById<TextView>(R.id.meditationTitle)
        title.text = meditationImages[position].title

        val meditationImage = holder.itemView.findViewById<ImageView>(R.id.meditationImage)
        val width = meditationImage.width
        val height =
            (meditationImages[position].height * Resources.getSystem().displayMetrics.density + 0.5f).toInt()
        meditationImage.layoutParams = ViewGroup.LayoutParams(width, height)

        val layout = holder.itemView.findViewById<ConstraintLayout>(R.id.meditationLayout)
        val margin = (20 * Resources.getSystem().displayMetrics.density + 0.5f).toInt()
        val params = layout.layoutParams as ViewGroup.MarginLayoutParams
        params.setMargins(0, 0, margin, margin)

        meditationImage.setImageResource(meditationImages[position].imageRes)
    }

    class MeditationImageViewHolder(binding: MeditationImageElementBinding) :
        RecyclerView.ViewHolder(binding.root)
}