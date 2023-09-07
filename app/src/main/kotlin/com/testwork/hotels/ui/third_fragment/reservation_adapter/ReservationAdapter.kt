package com.testwork.hotels.ui.third_fragment.reservation_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testwork.domain.models.DelegateAdapterItem
import com.testwork.domain.models.pres_model.ReservationDto
import com.testwork.hotels.databinding.ReservationItemBinding
import com.testwork.hotels.ui.base.delegateAdapter.DelegateAdapter

class ReservationAdapter() :
    DelegateAdapter<ReservationDto, ReservationViewHolder>(ReservationDto::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        ReservationViewHolder(
            ReservationItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun bindViewHolder(
        model: ReservationDto,
        viewHolder: ReservationViewHolder,
        payloads: List<DelegateAdapterItem.Payloadable>
    ) {
        viewHolder.bind(model)
    }

}