package com.testwork.hotels.ui.third_fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.testwork.domain.base.AppEvent
import com.testwork.domain.models.exeptions.EmailValidateException
import com.testwork.domain.models.exeptions.ValidateColumnException
import com.testwork.domain.models.pres_model.ReservationDto
import com.testwork.hotels.R
import com.testwork.hotels.TAG
import com.testwork.hotels.databinding.ThirdFragmentBinding
import com.testwork.hotels.ui.base.BaseViewBindingFragment
import com.testwork.hotels.ui.third_fragment.reservation_adapter.TouristsAdapter
import com.testwork.hotels.ui.third_fragment.view_model.ReservationViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ThirdFragment : BaseViewBindingFragment<ThirdFragmentBinding>(ThirdFragmentBinding::inflate) {


    private val viewModel: ReservationViewModel by viewModel()

    private val compositeAdapter by lazy {
        TouristsAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
        initTouristListAdapter()
        super.onViewCreated(view, savedInstanceState)
        initSubscribers()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initView() {
        with(binding) {
            nextButton.setOnClickListener {
                if (viewModel.validateEmailLiveData.value is AppEvent.Success
                    && viewModel.validatePhoneLiveData.value is AppEvent.Success
                ) {
                    val action = ThirdFragmentDirections.actionThirdFragmentToFourthFragment()
                    findNavController().navigate(action)
                } else {
                    val email = emailEditText.text.toString()
                    val number = viewModel.formatNumber(phoneMaskedEditText.text.toString())
                    viewModel.validateUserEmail(email)
                    viewModel.validatePhoneNumber(number)
                }
            }

            addUserButton.setOnClickListener {
                viewModel.addNewTourist()
            }
            toolbar.titleText.text = getString(R.string.reservation_title)
            toolbar.arrowLeftBack.setOnClickListener {
                findNavController().popBackStack()
            }

            phoneMaskedEditText.setOnFocusChangeListener { _, _ ->
                mainScrollContainer.smoothScrollTo(0, binding.agreemnetTextView.top)
            }

            emailEditText.setOnFocusChangeListener { _, _ ->
                mainScrollContainer.smoothScrollTo(0, binding.agreemnetTextView.top)
            }

            phoneMaskedEditText.doOnTextChanged { text, _, _, _ ->
                text?.let {
                    val number = viewModel.formatNumber(it.toString())
                    viewModel.validatePhoneNumber(number)
                }
            }
            initEmailListener()

        }
    }

    private fun initSubscribers() {
        viewModel.reservationLiveData.observe(viewLifecycleOwner) {
            setViewData(it)
        }

        viewModel.validatePhoneLiveData.observe(viewLifecycleOwner) {
            setStatePhone(it)
        }

        viewModel.validateEmailLiveData.observe(viewLifecycleOwner) {
            setStateUserEmail(it)
        }

        viewModel.touristsList.observe(viewLifecycleOwner) {
            Log.d(TAG, "VIEW: NEW LIST = $it")
            compositeAdapter.submitList(it)
        }

        viewModel.price.observe(viewLifecycleOwner) {
            //todo set data
        }
    }

    private fun initTouristListAdapter() {
        with(binding) {
            touristListRv.adapter = compositeAdapter
            touristListRv.itemAnimator = object : DefaultItemAnimator() {
                override fun canReuseUpdatedViewHolder(viewHolder: RecyclerView.ViewHolder): Boolean {
                    return true
                }
            }
            touristListRv.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            touristListRv.isNestedScrollingEnabled = false
        }
    }

    private fun setViewData(data: ReservationDto) {
        with(binding) {
            ratingLayout.ratingText.text =
                getString(R.string.f_f_rating, data.horating, data.ratingName)
            tvHotelName.text = data.hotelName
            tvHotelAddress.text = data.hotelAddress

            departure.title.text = getString(R.string.departure_title)
            departure.data.text = data.departure

            country.title.text = getString(R.string.country_city)
            country.data.text = data.arrivalCountry

            date.title.text = getString(R.string.dates)
            date.data.text = getString(R.string.dates_value, data.tourDateStart, data.tourDateStop)


            countOfNight.title.text = getString(R.string.count_of_night)
            countOfNight.data.text = resources.getQuantityString(
                R.plurals.count_of_night_value,
                data.numberOfNights,
                data.numberOfNights
            )

            hotel.title.text = getString(R.string.hotel)
            hotel.data.text = data.hotelName

            room.title.text = getString(R.string.room_number)
            room.data.text = data.room

            eat.title.text = getString(R.string.eat)
            eat.data.text = data.nutrition


        }
    }

    private fun setStateUserEmail(state: AppEvent<*>) {
        when (state) {
            is AppEvent.Error -> {
                when (state.error) {
                    is EmailValidateException -> {
                        binding.emailLayout.setBackgroundResource(R.drawable.error_shape)
                        binding.emailEditText.error =
                            (state.error as EmailValidateException).message
                    }
                }
            }

            is AppEvent.Success -> {
                when (val item = state.data) {
                    is String -> {
                        val text = binding.emailEditText.text.toString()
                        binding.emailLayout.setBackgroundResource(0)
                        binding.emailEditText.error = null
                        if (text != item) {
                            binding.emailEditText.setText(item)
                        }
                    }
                }
            }

            else -> {}
        }
    }


    private fun setStatePhone(state: AppEvent<*>) {
        when (state) {
            is AppEvent.Error -> {
                when (state.error) {
                    is ValidateColumnException -> {
                        binding.phoneLayout.setBackgroundResource(R.drawable.error_shape)
                        binding.phoneMaskedEditText.error =
                            (state.error as ValidateColumnException).message
                    }
                }
            }

            is AppEvent.Success -> {
                when (state.data) {
                    is String -> {
                        binding.phoneLayout.setBackgroundResource(0)
                        binding.phoneMaskedEditText.error = null
                    }
                }

            }

            else -> {}
        }
    }

    private fun initEmailListener() {
        binding.emailEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                viewModel.validateUserEmail(s.toString())
            }
        })
    }

}