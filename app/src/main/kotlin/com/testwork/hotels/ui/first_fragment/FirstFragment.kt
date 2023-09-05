package com.testwork.hotels.ui.first_fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.testwork.hotels.databinding.FirstFragmentBinding
import com.testwork.hotels.ui.base.BaseViewBindingFragment
import com.testwork.hotels.ui.base.IOnClickNavigate
import com.testwork.hotels.ui.base.delegateAdapter.CompositeAdapter
import com.testwork.hotels.ui.first_fragment.adapter.FirstFragmentAdapter
import com.testwork.hotels.ui.first_fragment.view_model.HotelViewModel
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class FirstFragment : BaseViewBindingFragment<FirstFragmentBinding>(FirstFragmentBinding::inflate),
    IOnClickNavigate {

    private val viewModel: HotelViewModel by activityViewModel()

    private val compositeAdapter by lazy {
        CompositeAdapter.Builder()
            .add(FirstFragmentAdapter(this))
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

    override fun toNextFragmentClicked() {
        val action = FirstFragmentDirections
            .actionFirstFragmentToSecondFragment(hotelName = viewModel.getHotelName())
        findNavController().navigate(action)
    }
}

