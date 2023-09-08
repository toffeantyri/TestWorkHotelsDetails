package com.testwork.hotels.ui.first_fragment.adapter_includes_opt

import androidx.recyclerview.widget.RecyclerView
import com.testwork.hotels.databinding.IncludesOptItemBinding
import com.testwork.hotels.ui.models.IncludesTitleDto

class IncludesViewHolder(private val binding: IncludesOptItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private val context = binding.root.context

    fun bind(item: IncludesTitleDto) {
        with(binding) {
            imageView.setImageResource(item.icon)
            title.text = context.getString(item.title)
            description.text = context.getString(item.desc)
        }

    }

}
