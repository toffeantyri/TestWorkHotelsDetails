package com.testwork.hotels.ui.third_fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.testwork.hotels.databinding.ThirdFragmentBinding
import com.testwork.hotels.ui.base.BaseViewBindingFragment
import com.testwork.hotels.ui.base.IOnClickNavigate
import com.testwork.hotels.ui.base.delegateAdapter.CompositeAdapter
import com.testwork.hotels.ui.third_fragment.reservation_adapter.ReservationAdapter
import com.testwork.hotels.ui.third_fragment.view_model.ReservationViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ThirdFragment : BaseViewBindingFragment<ThirdFragmentBinding>(ThirdFragmentBinding::inflate),
    IOnClickNavigate {

    private val viewModel: ReservationViewModel by viewModel()

    private val compositeAdapter by lazy {
        CompositeAdapter.Builder()
            .add(ReservationAdapter(this))
            .build()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecycler()
        super.onViewCreated(view, savedInstanceState)
        initSubscribers()
    }


    private fun initRecycler() {
        with(binding) {
            resRecycler.adapter = compositeAdapter
            resRecycler.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun initSubscribers() {
        viewModel.reservationLiveData.observe(viewLifecycleOwner) {
            compositeAdapter.submitList(listOf(it))
        }
    }


    override fun toNextFragmentClicked(pos: Int) {
        val action = ThirdFragmentDirections.actionThirdFragmentToFourthFragment()
        findNavController().navigate(action)
    }


}