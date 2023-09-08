package com.testwork.hotels.ui.third_fragment.reservation_adapter

import android.animation.LayoutTransition
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputLayout
import com.testwork.hotels.R
import com.testwork.hotels.databinding.TouristItemBinding
import com.testwork.hotels.ui.models.TouristDto
import com.testwork.hotels.ui.third_fragment.utils.TouristInterface

class TouristViewHolder(
    private val binding: TouristItemBinding,
    private val touristInterface: TouristInterface,
    private val touristDataInterface: DataChangerCallbackInterface
) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        const val ARROW_OPEN_POS = 270f
        const val ARROW_CLOSE_POS = 90f
    }

    private val context = binding.root.context

    fun bind(item: TouristDto, isOpen: Boolean) {
        with(binding) {
            mainConstraintContainer.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
            mainConstraintContainer.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

            val touristNumberText = buildString {
                if (adapterPosition < 2) {
                    append(
                        context.resources.getQuantityString(
                            R.plurals.add_user_text,
                            adapterPosition + 1
                        )
                    )
                } else {
                    append(context.getString(R.string.add_user_text_with_d, adapterPosition + 1))
                }
                append(context.getString(R.string.tourist))
            }

            touristNumber.text = touristNumberText

            fieldContainer.isVisible = isOpen
            openCloseButton.rotation = if (isOpen) ARROW_OPEN_POS else ARROW_CLOSE_POS
            openCloseButton.setOnClickListener {
                if (isOpen) touristInterface.closeItem(adapterPosition) else touristInterface.openItem(
                    adapterPosition
                )
            }

            nameEditText.apply {
                setText(item.firstName)
                if (item.needValidate) {
                    nameLayout.checkIsEmpty(item.firstName)
                }
                nameEditText.doOnTextChanged { text, _, _, _ ->
                    nameLayout.checkIsEmpty(text.toString())
                    touristDataInterface.nameChanged(adapterPosition, text.toString())
                }
            }

            secondNameEt.apply {
                setText(item.secondName)
                if (item.needValidate) {
                    secondNamelayout.checkIsEmpty(item.secondName)
                }
                secondNameEt.doOnTextChanged { text, _, _, _ ->
                    secondNamelayout.checkIsEmpty(text.toString())
                    touristDataInterface.secondNameChanged(adapterPosition, text.toString())
                }
            }
            dateOfBirthEdText.apply {
                setText(item.dateOfBirth)
                if (item.needValidate) {
                    dateOfBirthLayout.checkIsEmpty(item.dateOfBirth)
                }
                dateOfBirthEdText.doOnTextChanged { text, _, _, _ ->
                    dateOfBirthLayout.checkIsEmpty(text.toString())
                    touristDataInterface.dateOfBirthChanged(adapterPosition, text.toString())
                }
            }
            citizEditText.apply {
                setText(item.citizenShip)
                if (item.needValidate) {
                    citizLayout.checkIsEmpty(item.citizenShip)
                }
                citizEditText.doOnTextChanged { text, _, _, _ ->
                    citizLayout.checkIsEmpty(text.toString())
                    touristDataInterface.citizenshipChanged(adapterPosition, text.toString())
                }
            }

            paspNumbEditText.apply {
                setText(item.passportNumbers)
                if (item.needValidate) {
                    paspNumbLayout.checkIsEmpty(item.passportNumbers)
                }
                paspNumbEditText.doOnTextChanged { text, _, _, _ ->
                    paspNumbLayout.checkIsEmpty(text.toString())
                    touristDataInterface.paspNumberChanged(adapterPosition, text.toString())
                }
            }

            dateEndPaspEditText.apply {
                setText(item.endDateOfPassport)
                if (item.needValidate) {
                    dateEndPaspLayout.checkIsEmpty(item.endDateOfPassport)
                }
                dateEndPaspEditText.doOnTextChanged { text, _, _, _ ->
                    dateEndPaspLayout.checkIsEmpty(text.toString())
                    touristDataInterface.paspEndDateChanged(adapterPosition, text.toString())
                }
            }
            item.needValidate = false
        }
    }

    private fun TextInputLayout.checkIsEmpty(text: String?) {
        if (text?.isEmpty() == true) {
            this.setBackgroundResource(R.drawable.error_shape)
        } else {
            this.setBackgroundResource(0)
        }
    }


}