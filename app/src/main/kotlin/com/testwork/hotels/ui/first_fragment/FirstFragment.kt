package com.testwork.hotels.ui.first_fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.testwork.domain.models.HotelDto
import com.testwork.hotels.databinding.FirstFragmentBinding
import com.testwork.hotels.ui.base.BaseViewBindingFragment
import com.testwork.hotels.ui.base.delegateAdapter.CompositeAdapter
import com.testwork.hotels.ui.first_fragment.adapter.FirstFragmentAdapter

class FirstFragment : BaseViewBindingFragment<FirstFragmentBinding>(FirstFragmentBinding::inflate) {

    private val compositeAdapter by lazy {
        CompositeAdapter.Builder().add(FirstFragmentAdapter())
            .build()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecyclerView()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initRecyclerView() {
        with(binding) {
            mainRecycler.adapter = compositeAdapter
            mainRecycler.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            compositeAdapter.submitList(
                listOf(
                    HotelDto(
                        "Ленина 21",
                        0,
                        emptyList(),
                        minimalPrice = 300000,
                        name = "Great Resort",
                        priceForIt = "за День",
                        ratingName = "Нормас",
                        rating = 6,
                        description = "Под пивас пойдет",
                        peculiarities = emptyList()
                    )
                )
            )
        }
    }
}

