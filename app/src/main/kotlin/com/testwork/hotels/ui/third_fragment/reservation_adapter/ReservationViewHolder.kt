package com.testwork.hotels.ui.third_fragment.reservation_adapter

import androidx.recyclerview.widget.RecyclerView
import com.testwork.domain.models.ReservationDto
import com.testwork.hotels.databinding.ReservationItemBinding
import com.testwork.hotels.ui.base.IOnClickNavigate

class ReservationViewHolder(
    private val binding: ReservationItemBinding,
    private val onClickChoose: IOnClickNavigate
) :
    RecyclerView.ViewHolder(binding.root) {

    private val context = binding.root.context

    fun bind(item: ReservationDto) {
        with(binding) {
            nextButton.setOnClickListener {
                onClickChoose.toNextFragmentClicked(adapterPosition)
            }

            //todo
        }
    }
}