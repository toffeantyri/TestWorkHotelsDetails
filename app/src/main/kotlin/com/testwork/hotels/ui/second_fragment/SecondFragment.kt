package com.testwork.hotels.ui.second_fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.testwork.hotels.databinding.SecondFragmentBinding
import com.testwork.hotels.ui.base.BaseViewBindingFragment
import com.testwork.hotels.ui.base.IOnClickNavigate
import com.testwork.hotels.ui.base.delegateAdapter.CompositeAdapter
import com.testwork.hotels.ui.second_fragment.numbers_adapter.NumbersAdapter
import com.testwork.hotels.ui.second_fragment.view_model.NumbersViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondFragment :
    BaseViewBindingFragment<SecondFragmentBinding>(SecondFragmentBinding::inflate),
    IOnClickNavigate {

    private val viewModel: NumbersViewModel by viewModel()

    private val args: SecondFragmentArgs by navArgs()

    private val compositeAdapter by lazy {
        CompositeAdapter.Builder()
            .add(NumbersAdapter(this))
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
            layoutToolbar.arrowLeftBack.setOnClickListener {
                findNavController().popBackStack()
            }
            layoutToolbar.titleText.text = args.hotelName
        }
    }

    private fun initRecycler() {
        with(binding) {
            recycler.adapter = compositeAdapter
            recycler.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun initSubscribers() {
        viewModel.numbersLiveData.observe(viewLifecycleOwner) {
            compositeAdapter.submitList(it)
        }
    }

    override fun toNextFragmentClicked(pos: Int) {
        val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment()
        findNavController().navigate(action)
    }

}