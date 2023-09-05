package com.testwork.hotels.ui.second_fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.testwork.hotels.databinding.SecondFragmentBinding
import com.testwork.hotels.ui.base.BaseViewBindingFragment
import com.testwork.hotels.ui.second_fragment.view_model.NumbersViewModel
import com.testwork.hotels.ui.utils.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondFragment :
    BaseViewBindingFragment<SecondFragmentBinding>(SecondFragmentBinding::inflate) {

    private val viewModel: NumbersViewModel by viewModel()

    private val args: SecondFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
        super.onViewCreated(view, savedInstanceState)
        initSubscribers()
    }

    private fun initView() {
        with(binding) {
            //todo
            context?.showToast(args.hotelName)
        }
    }

    private fun initSubscribers() {
        viewModel.numbersLiveData.observe(viewLifecycleOwner) {
            //todo
            context?.showToast(it.getOrNull(0)?.name)
        }
    }

}