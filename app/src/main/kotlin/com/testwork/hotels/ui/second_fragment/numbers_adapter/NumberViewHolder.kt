package com.testwork.hotels.ui.second_fragment.numbers_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.testwork.domain.models.pres_model.LinkWrapperDto
import com.testwork.domain.models.pres_model.RoomDto
import com.testwork.hotels.R
import com.testwork.hotels.databinding.NumberItemBinding
import com.testwork.hotels.databinding.TextItemBinding
import com.testwork.hotels.ui.base.IOnClickNavigate
import com.testwork.hotels.ui.base.delegateAdapter.CompositeAdapter
import com.testwork.hotels.ui.base.image_adapter.ImageSliderAdapter

class NumberViewHolder(
    private val binding: NumberItemBinding,
    private val onClickChoose: IOnClickNavigate
) :
    RecyclerView.ViewHolder(binding.root) {

    private val context = binding.root.context

    private val compositeAdapter by lazy {
        CompositeAdapter.Builder()
            .add(ImageSliderAdapter())
            .build()
    }

    fun bind(item: RoomDto) {
        with(binding) {
            nextButton.setOnClickListener {
                onClickChoose.toNextFragmentClicked(adapterPosition)
            }
            tvNumberName.text = item.name
            numberMinPrice.text = context.getString(R.string.f_f_price, item.price)
            numberMinPriceBy.text = item.pricePer
            initViewPager(item.imageUrls)
            initFlowGroup(item.peculiarities)

        }
    }

    private fun initViewPager(list: List<LinkWrapperDto>) {
        with(binding) {
            imagePagerNumbr.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            imagePagerNumbr.adapter = compositeAdapter
            TabLayoutMediator(tabIndicator, imagePagerNumbr) { _, _ ->
            }.attach()
        }
        compositeAdapter.submitList(list)
    }

    private fun initFlowGroup(list: List<String>) {
        with(binding) {
            val idList = mutableListOf<Int>()
            list.forEach {
                val viewBinding = TextItemBinding.inflate(LayoutInflater.from(context)).apply {
                    root.layoutParams = ConstraintLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val id = View.generateViewId()
                    idList.add(id)
                    root.id = id
                    imageView.text = it
                }
                contraintContainer.addView(viewBinding.root)

            }
            flowGroup.referencedIds = idList.toIntArray()
        }
    }

}

