package com.testwork.hotels.ui.first_fragment.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.testwork.domain.models.HotelDto
import com.testwork.domain.models.LinkWrapperDto
import com.testwork.hotels.R
import com.testwork.hotels.databinding.FirstFragmentFullItemBinding
import com.testwork.hotels.ui.base.delegateAdapter.CompositeAdapter
import com.testwork.hotels.ui.base.image_adapter.ImageSliderAdapter

class HotelViewHolder(private val binding: FirstFragmentFullItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private val context = binding.root.context

    private val compositeAdapter by lazy {
        CompositeAdapter.Builder()
            .add(ImageSliderAdapter())
            .build()
    }

    fun bind(item: HotelDto) {
        with(binding) {
            tvHotelName.text = item.name
            tvHotelAddress.text = item.address

            hotelMinPrice.text = context.getString(R.string.f_f_price, item.minimalPrice)
            hotelMinPriceBy.text = item.priceForIt

            ratingLayout.ratingText.text =
                context.getString(R.string.f_f_rating, item.rating, item.ratingName)
            tvDescription.text = item.description
            initViewPager(item.imageUrls)


        }
    }

    private fun initViewPager(list: List<LinkWrapperDto>) {
        with(binding) {
            imagePager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            imagePager.adapter = compositeAdapter
            TabLayoutMediator(tabIndicator, imagePager) { _, _ ->
            }.attach()
        }
        compositeAdapter.submitList(list)
    }
}
