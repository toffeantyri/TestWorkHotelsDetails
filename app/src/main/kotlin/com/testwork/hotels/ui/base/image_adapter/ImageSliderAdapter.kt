package com.testwork.hotels.ui.base.image_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testwork.domain.models.DelegateAdapterItem
import com.testwork.domain.models.LinkWrapperDto
import com.testwork.hotels.databinding.ImageItemBinding
import com.testwork.hotels.ui.base.delegateAdapter.DelegateAdapter

class ImageSliderAdapter :
    DelegateAdapter<LinkWrapperDto, ImageViewHolder>(LinkWrapperDto::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        ImageViewHolder(
            ImageItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun bindViewHolder(
        model: LinkWrapperDto,
        viewHolder: ImageViewHolder,
        payloads: List<DelegateAdapterItem.Payloadable>
    ) {
        viewHolder.bind(model)
    }


}