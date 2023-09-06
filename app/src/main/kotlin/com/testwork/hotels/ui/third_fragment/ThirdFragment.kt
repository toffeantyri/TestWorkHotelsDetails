package com.testwork.hotels.ui.third_fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.testwork.hotels.databinding.ThirdFragmentBinding
import com.testwork.hotels.ui.base.BaseViewBindingFragment
import com.testwork.hotels.ui.base.delegateAdapter.CompositeAdapter
import com.testwork.hotels.ui.third_fragment.reservation_adapter.ReservationAdapter
import com.testwork.hotels.ui.third_fragment.view_model.ReservationViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ThirdFragment : BaseViewBindingFragment<ThirdFragmentBinding>(ThirdFragmentBinding::inflate) {

    private val viewModel: ReservationViewModel by viewModel()

    private val compositeAdapter by lazy {
        CompositeAdapter.Builder()
            .add(ReservationAdapter())
            .build()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
        initRecycler()
        super.onViewCreated(view, savedInstanceState)
        initSubscribers()
    }

    private fun initView() {
        with(binding) {
            nextButton.setOnClickListener {
                val action = ThirdFragmentDirections.actionThirdFragmentToFourthFragment()
                findNavController().navigate(action)
            }


        }
    }


    private fun initRecycler() {
        with(binding) {

        }
    }

    private fun initSubscribers() {
        viewModel.reservationLiveData.observe(viewLifecycleOwner) {
            compositeAdapter.submitList(listOf(it))
        }
    }


}