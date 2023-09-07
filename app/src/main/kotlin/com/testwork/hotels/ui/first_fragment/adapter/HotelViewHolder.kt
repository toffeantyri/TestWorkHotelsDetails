package com.testwork.hotels.ui.first_fragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.testwork.domain.models.pres_model.HotelDto
import com.testwork.domain.models.pres_model.LinkWrapperDto
import com.testwork.hotels.R
import com.testwork.hotels.databinding.FirstFragmentFullItemBinding
import com.testwork.hotels.databinding.TextItemBinding
import com.testwork.hotels.ui.base.IOnClickNavigate
import com.testwork.hotels.ui.base.delegateAdapter.CompositeAdapter
import com.testwork.hotels.ui.base.image_adapter.ImageSliderAdapter
import com.testwork.hotels.ui.first_fragment.adapter_includes_opt.IncludeOptionsAdapter
import com.testwork.hotels.ui.models.IncludesTitleDto

class HotelViewHolder(
    private val binding: FirstFragmentFullItemBinding,
    private val onClickNext: IOnClickNavigate
) :
    RecyclerView.ViewHolder(binding.root) {

    private val context = binding.root.context

    private val compositeAdapter by lazy {
        CompositeAdapter.Builder()
            .add(ImageSliderAdapter())
            .build()
    }

    private val includesAdapter by lazy {
        CompositeAdapter.Builder()
            .add(IncludeOptionsAdapter())
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
            nextButton.setOnClickListener {
                onClickNext.toNextFragmentClicked(adapterPosition)
            }
            initViewPager(item.imageUrls)
            initFlowGroup(item.peculiarities)
            initIncludesOpt()
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

    private fun initFlowGroup(list: List<String>) {
        with(binding) {
            val idList = mutableListOf<Int>()
            list.forEach {
                val viewBinding = TextItemBinding.inflate(LayoutInflater.from(context)).apply {
                    root.layoutParams = ConstraintLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
                    val id = View.generateViewId()
                    idList.add(id)
                    root.id = id
                    imageView.text = it
                }
                constraintLayoutContainer.addView(viewBinding.root)

            }
            flowGroup.referencedIds = idList.toIntArray()
        }
    }

    private fun initIncludesOpt() {
        with(binding) {
            includesOptions.adapter = includesAdapter
            includesOptions.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            includesAdapter.submitList(
                listOf(
                    IncludesTitleDto(
                        R.drawable.ic_comfort,
                        R.string.comfort,
                        R.string.most_important
                    ),
                    IncludesTitleDto(
                        R.drawable.ic_includes,
                        R.string.incl,
                        R.string.most_important
                    ),
                    IncludesTitleDto(
                        R.drawable.not_includes,
                        R.string.not_incl,
                        R.string.most_important
                    )
                )
            )
        }
    }
}
