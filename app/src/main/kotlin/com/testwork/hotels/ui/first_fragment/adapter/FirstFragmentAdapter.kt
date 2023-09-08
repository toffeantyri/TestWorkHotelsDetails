package com.testwork.hotels.ui.first_fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testwork.domain.models.DelegateAdapterItem
import com.testwork.domain.models.pres_model.HotelDto
import com.testwork.hotels.databinding.FirstFragmentFullItemBinding
import com.testwork.hotels.ui.base.IOnClickNavigate
import com.testwork.hotels.ui.base.delegateAdapter.DelegateAdapter

class FirstFragmentAdapter(private val navInterface: IOnClickNavigate) :
    DelegateAdapter<HotelDto, HotelViewHolder>(HotelDto::class.java) {


    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        HotelViewHolder(
            FirstFragmentFullItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            navInterface
        )

    override fun bindViewHolder(
        model: HotelDto,
        viewHolder: HotelViewHolder,
        payloads: List<DelegateAdapterItem.Payloadable>
    ) {
        viewHolder.bind(model)
    }


}