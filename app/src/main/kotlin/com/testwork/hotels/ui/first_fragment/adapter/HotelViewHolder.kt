package com.testwork.hotels.ui.first_fragment.adapter

import androidx.recyclerview.widget.RecyclerView
import com.testwork.domain.models.HotelDto
import com.testwork.hotels.R
import com.testwork.hotels.databinding.FirstFragmentFullItemBinding

class HotelViewHolder(private val binding: FirstFragmentFullItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private val context = binding.root.context

    fun bind(item: HotelDto) {
        with(binding) {
            tvHotelName.text = item.name
            tvHotelAddress.text = item.address

            hotelMinPrice.text = context.getString(R.string.f_f_price, item.minimalPrice)
            hotelMinPriceBy.text = item.priceForIt

            ratingLayout.ratingText.text =
                context.getString(R.string.f_f_rating, item.rating, item.ratingName)

            tvDescription.text = item.description


        }
    }
}