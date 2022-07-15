package com.sirius.test_app.uiFragment.adapters

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.sirius.test_app.R
import com.sirius.test_app.databinding.StarItemBinding

class StarsAdapter(private val rating: Int) : RecyclerView.Adapter<StarsAdapter.StarsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarsViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.star_item, parent, false)
        return StarsViewHolder(view)
    }

    override fun onBindViewHolder(holder: StarsViewHolder, position: Int) {
        holder.onBindColor(position)
    }

    override fun getItemCount(): Int = rating

    inner class StarsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = StarItemBinding.bind(itemView)

        fun onBindColor(position: Int) {
            binding.ivStar.let {
                val colorId = if (position < rating) R.color.yellow else R.color.gray_dark
                ImageViewCompat.setImageTintList(
                    binding.ivStar, ColorStateList.valueOf(
                        ContextCompat.getColor(binding.ivStar.context, colorId)
                    )
                )
            }
        }
    }
}