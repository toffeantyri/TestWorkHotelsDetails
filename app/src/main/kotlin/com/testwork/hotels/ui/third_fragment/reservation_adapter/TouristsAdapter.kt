package com.testwork.hotels.ui.third_fragment.reservation_adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testwork.hotels.databinding.TouristItemBinding
import com.testwork.hotels.ui.base.TouristInterface
import com.testwork.hotels.ui.models.TouristDto

class TouristsAdapter : RecyclerView.Adapter<TouristViewHolder>(), TouristInterface {

    companion object {
        const val FIRST_TOURIST_INDEX = 0
    }

    private var itemList: List<TouristDto> = listOf()

    private val posExpanded = arrayListOf<Int>(FIRST_TOURIST_INDEX)

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<TouristDto>) {
        itemList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TouristViewHolder {
        return TouristViewHolder(
            TouristItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), this
        )
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: TouristViewHolder, position: Int) {
        holder.bind(itemList[position], posExpanded.contains(position))
    }

    override fun openItem(pos: Int) {
        posExpanded.add(pos)
        notifyItemChanged(pos)
    }

    override fun closeItem(pos: Int) {
        posExpanded.remove(pos)
        notifyItemChanged(pos)
    }

}