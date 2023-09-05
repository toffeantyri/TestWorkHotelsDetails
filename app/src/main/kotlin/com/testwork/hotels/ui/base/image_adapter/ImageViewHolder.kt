package com.testwork.hotels.ui.base.image_adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.testwork.domain.models.LinkWrapperDto
import com.testwork.hotels.R
import com.testwork.hotels.databinding.ImageItemBinding
import com.testwork.hotels.ui.utils.toPx

class ImageViewHolder(private val binding: ImageItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private val context = binding.root.context

    fun bind(item: LinkWrapperDto) {
        with(binding) {
            imageView.load(item.link) {
                transformations(
                    RoundedCornersTransformation(
                        context.resources.getDimension(R.dimen.image_radius).toPx()
                    )
                )
            }
        }


    }

}