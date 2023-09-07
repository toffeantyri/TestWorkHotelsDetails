package com.testwork.hotels.ui.third_fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.testwork.domain.models.ReservationDto
import com.testwork.hotels.R
import com.testwork.hotels.databinding.ThirdFragmentBinding
import com.testwork.hotels.ui.base.BaseViewBindingFragment
import com.testwork.hotels.ui.base.delegateAdapter.CompositeAdapter
import com.testwork.hotels.ui.third_fragment.reservation_adapter.ReservationAdapter
import com.testwork.hotels.ui.third_fragment.view_model.ReservationViewModel
import com.testwork.hotels.ui.utils.showToast
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
        super.onViewCreated(view, savedInstanceState)
        initSubscribers()
    }

    private fun initView() {
        with(binding) {
            nextButton.setOnClickListener {
                val action = ThirdFragmentDirections.actionThirdFragmentToFourthFragment()
                findNavController().navigate(action)
            }
            toolbar.titleText.text = getString(R.string.reservation_title)
            toolbar.arrowLeftBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun initSubscribers() {
        viewModel.reservationLiveData.observe(viewLifecycleOwner) {
            setViewData(it)
            context?.showToast(it.arrivalCountry)
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

}