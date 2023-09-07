package com.testwork.hotels.ui.third_fragment.reservation_adapter

import androidx.recyclerview.widget.RecyclerView
import com.testwork.domain.models.pres_model.ReservationDto
import com.testwork.hotels.databinding.ReservationItemBinding

class ReservationViewHolder(
    private val binding: ReservationItemBinding
) :
    RecyclerView.ViewHolder(binding.root) {

    private val context = binding.root.context

    fun bind(item: ReservationDto) {
        with(binding) {

        }
    }
}