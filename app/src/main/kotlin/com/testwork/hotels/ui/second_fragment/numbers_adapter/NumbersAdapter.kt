package com.testwork.hotels.ui.second_fragment.numbers_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testwork.domain.models.DelegateAdapterItem
import com.testwork.domain.models.RoomDto
import com.testwork.hotels.databinding.NumberItemBinding
import com.testwork.hotels.ui.base.IOnClickNavigate
import com.testwork.hotels.ui.base.delegateAdapter.DelegateAdapter

class NumbersAdapter(private val onClickNavigate: IOnClickNavigate) :
    DelegateAdapter<RoomDto, NumberViewHolder>(RoomDto::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        NumberViewHolder(
            NumberItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            onClickNavigate
        )

    override fun bindViewHolder(
        model: RoomDto,
        viewHolder: NumberViewHolder,
        payloads: List<DelegateAdapterItem.Payloadable>
    ) {
        viewHolder.bind(model)
    }

}