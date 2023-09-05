package com.testwork.hotels.ui.first_fragment.adapter_includes_opt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testwork.domain.models.DelegateAdapterItem
import com.testwork.hotels.databinding.IncludesOptItemBinding
import com.testwork.hotels.ui.base.delegateAdapter.DelegateAdapter
import com.testwork.hotels.ui.models.IncludesTitleDto

class IncludeOptionsAdapter :
    DelegateAdapter<IncludesTitleDto, IncludesViewHolder>(IncludesTitleDto::class.java) {


    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        IncludesViewHolder(
            IncludesOptItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun bindViewHolder(
        model: IncludesTitleDto,
        viewHolder: IncludesViewHolder,
        payloads: List<DelegateAdapterItem.Payloadable>
    ) {
        viewHolder.bind(model)
    }


}