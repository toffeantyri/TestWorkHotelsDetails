package com.testwork.hotels.ui.fourth_fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.testwork.hotels.R
import com.testwork.hotels.databinding.FourthFragmentBinding
import com.testwork.hotels.ui.base.BaseViewBindingFragment
import com.testwork.hotels.ui.fourth_fragment.viewmodel.SuccessViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FourthFragment :
    BaseViewBindingFragment<FourthFragmentBinding>(FourthFragmentBinding::inflate) {

    private val viewModel: SuccessViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
        super.onViewCreated(view, savedInstanceState)
        initSubscribers()
    }

    private fun initSubscribers() {
        lifecycleScope.launch {
            viewModel.getOrderNumber().collect {
                binding.tvDescription.text = getString(R.string.order_text_with_numbers, it)
            }
        }
    }

    private fun initView() {
        with(binding) {
            nextButton.setOnClickListener {
                val action = FourthFragmentDirections.actionFourthFragmentToFirstFramgnet()
                findNavController().navigate(action)
            }
        }
    }

}