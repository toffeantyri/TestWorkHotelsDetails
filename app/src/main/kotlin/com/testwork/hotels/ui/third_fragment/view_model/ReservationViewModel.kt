package com.testwork.hotels.ui.third_fragment.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testwork.domain.base.AppEvent
import com.testwork.domain.interactors.ValidateInteractor
import com.testwork.domain.models.pres_model.ReservationDto
import com.testwork.domain.use_cases.reservation.ReservationUseCase
import com.testwork.hotels.TAG
import com.testwork.hotels.ui.models.PriceDto
import com.testwork.hotels.ui.models.TouristDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ReservationViewModel(
    private val reservationUseCase: ReservationUseCase,
    private val validator: ValidateInteractor
) : ViewModel() {

    private val _validatePhoneLiveData: MutableLiveData<AppEvent<*>> by lazy {
        MutableLiveData()
    }
    val validatePhoneLiveData: LiveData<AppEvent<*>> get() = _validatePhoneLiveData

    private val _validateEmailLiveData: MutableLiveData<AppEvent<*>> by lazy {
        MutableLiveData()
    }
    val validateEmailLiveData: LiveData<AppEvent<*>> get() = _validateEmailLiveData

    private val _reservationLiveData: MutableLiveData<ReservationDto> by lazy {
        MutableLiveData()
    }
    val reservationLiveData: LiveData<ReservationDto> get() = _reservationLiveData

    private val _touristValidateLiveData: MutableLiveData<AppEvent<*>> =
        MutableLiveData()


    val touristsList: MutableLiveData<List<TouristDto>> by lazy {
        MutableLiveData(listOf(TouristDto()))
    }

    val price: MutableLiveData<PriceDto> by lazy {
        MutableLiveData()
    }

    fun getTouristsDataState(): AppEvent<*> {
        return _touristValidateLiveData.value ?: AppEvent.Error<Throwable>(null)
    }

    init {
        getReservationData()
    }

    private fun getReservationData() {
        viewModelScope.launch {
            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                    reservationUseCase.execute()
                }
            }.onSuccess {
                _reservationLiveData.value = it
                calculatePrice()
            }.onFailure {
                Log.d(TAG, "VM: $it")
            }
        }
    }

    fun formatNumber(number: String): String {
        return number.replace(Regex("\\D"), "")
    }

    fun validatePhoneNumber(number: String) {
        viewModelScope.launch {
            val formatNumber = formatNumber(number)
            validator.validateNumber(formatNumber).collect { state ->
                _validatePhoneLiveData.value = state
            }
        }
    }

    fun validateUserEmail(value: String) {
        viewModelScope.launch {
            validator.checkUserEmail(value).collect {
                _validateEmailLiveData.value = it
            }
        }
    }


    private fun calculatePrice() {
        viewModelScope.launch {
            _reservationLiveData.value?.let { data ->
                touristsList.value?.let { list ->
                    val newPrice = withContext(Dispatchers.Default) {
                        val touristCount = list.count()
                        val tourPrice = data.tourPrice * touristCount
                        val fuelCharge = data.fuelCharge * touristCount
                        val servCharge = data.serviceCharge * touristCount
                        val totalPirce = tourPrice + fuelCharge + servCharge
                        PriceDto(
                            tourPrice = tourPrice,
                            fuelPrice = fuelCharge,
                            servicePrice = servCharge,
                            totalPrice = totalPirce
                        )
                    }
                    price.value = newPrice
                }
            }
        }
    }

    fun addNewTourist() {
        val newList = touristsList.value?.toMutableList()
        newList?.add(TouristDto())
        touristsList.value = newList
        calculatePrice()
    }

    private fun touristDataChanged() {
        viewModelScope.launch {
            _touristValidateLiveData.value =
                if (touristsList.value?.all { it.fieldsIsNotEmpty() } == true)
                    AppEvent.Success(Unit)
                else AppEvent.Error<Throwable>(null)
        }
    }

    fun updateTouristValidation() {
        touristsList.value = touristsList.value?.map {
            it.needValidate = true
            it
        }
    }

    fun nameChanged(pos: Int, value: String) {
        touristsList.value?.getOrNull(pos)?.let { item ->
            item.firstName = value
            touristDataChanged()
        }
    }

    fun secondNameChanged(pos: Int, value: String) {
        touristsList.value?.getOrNull(pos)?.let { item ->
            item.secondName = value
            touristDataChanged()
        }
    }

    fun dateOfBirthChanged(pos: Int, value: String) {
        touristsList.value?.getOrNull(pos)?.let { item ->
            item.dateOfBirth = value
            touristDataChanged()
        }
    }

    fun citizenshipChanged(pos: Int, value: String) {
        touristsList.value?.getOrNull(pos)?.let { item ->
            item.citizenShip = value
            touristDataChanged()
        }
    }

    fun paspNumberChanged(pos: Int, value: String) {
        touristsList.value?.getOrNull(pos)?.let { item ->
            item.passportNumbers = value
            touristDataChanged()
        }
    }

    fun passportDateEndChanged(pos: Int, value: String) {
        touristsList.value?.getOrNull(pos)?.let { item ->
            item.endDateOfPassport = value
            touristDataChanged()
        }
    }

}