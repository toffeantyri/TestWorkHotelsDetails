package com.testwork.hotels.ui.third_fragment.reservation_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testwork.domain.models.DelegateAdapterItem
import com.testwork.hotels.databinding.TouristItemBinding
import com.testwork.hotels.ui.base.TouristInterface
import com.testwork.hotels.ui.base.delegateAdapter.DelegateAdapter
import com.testwork.hotels.ui.models.TouristDto

class TouristsAdapter(private val touristInterface: TouristInterface) :
    DelegateAdapter<TouristDto, TouristViewHolder>(TouristDto::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        TouristViewHolder(
            TouristItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), touristInterface
        )

    override fun bindViewHolder(
        model: TouristDto,
        viewHolder: TouristViewHolder,
        payloads: List<DelegateAdapterItem.Payloadable>
    ) {
        viewHolder.bind(model)
    }

}