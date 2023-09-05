package com.testwork.hotels.ui.first_fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.testwork.hotels.databinding.FirstFragmentBinding
import com.testwork.hotels.ui.base.BaseViewBindingFragment
import com.testwork.hotels.ui.base.delegateAdapter.CompositeAdapter
import com.testwork.hotels.ui.first_fragment.adapter.FirstFragmentAdapter
import com.testwork.hotels.ui.first_fragment.view_model.HotelViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FirstFragment : BaseViewBindingFragment<FirstFragmentBinding>(FirstFragmentBinding::inflate) {

    private val viewModel: HotelViewModel by viewModel()

    private val compositeAdapter by lazy {
        CompositeAdapter.Builder()
            .add(FirstFragmentAdapter())
            .build()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecyclerView()
        super.onViewCreated(view, savedInstanceState)
        initSubscribers()
    }

    private fun initRecyclerView() {
        with(binding) {
            mainRecycler.adapter = compositeAdapter
            mainRecycler.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }


    private fun initSubscribers() {
        viewModel.hotelLiveData.observe(viewLifecycleOwner) {
            compositeAdapter.submitList(listOf(it))
        }
    }
}

