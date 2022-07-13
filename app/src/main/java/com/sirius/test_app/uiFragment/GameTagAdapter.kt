package com.sirius.test_app.uiFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sirius.test_app.R

class GameTagAdapter(private val tags: List<String>) :
    RecyclerView.Adapter<GameTagAdapter.TagViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.tag_item, parent, false)

        return TagViewHolder(view)
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        holder.onBind(tags[position])
    }

    override fun getItemCount(): Int = tags.size

    inner class TagViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val tagName: TextView = itemView.findViewById(R.id.tvTag)

        fun onBind(tag: String){
            tagName.text = tag
        }
    }
}

