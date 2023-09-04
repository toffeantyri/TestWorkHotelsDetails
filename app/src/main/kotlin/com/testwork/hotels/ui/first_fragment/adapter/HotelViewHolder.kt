package com.testwork.hotels.ui.first_fragment.adapter

import androidx.recyclerview.widget.RecyclerView
import com.testwork.domain.models.HotelDto
import com.testwork.hotels.databinding.FirstFragmentFullItemBinding

class HotelViewHolder(private val binding: FirstFragmentFullItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: HotelDto) {
        with(binding) {
            tvHotelName.text = item.name
            tvDescription.text = item.description


        }
    }
}