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
    private val touristInterface: TouristInterface
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

            nameEditText.setText(item.firstName)
            nameEditText.doOnTextChanged { text, _, _, _ ->
                item.firstName = text.toString()
                nameLayout.checkIsEmpty(text.toString())

            }

            secondNameEt.setText(item.secondName)
            secondNameEt.doOnTextChanged { text, _, _, _ ->
                item.secondName = text.toString()
                secondNamelayout.checkIsEmpty(text.toString())

            }

            dateOfBirthEdText.setText(item.dateOfBirth)
            dateOfBirthEdText.doOnTextChanged { text, _, _, _ ->
                item.dateOfBirth = text.toString()
                dateOfBirthLayout.checkIsEmpty(text.toString())

            }

            citizEditText.setText(item.citizenShip)
            citizEditText.doOnTextChanged { text, _, _, _ ->
                item.citizenShip = text.toString()
                citizLayout.checkIsEmpty(text.toString())

            }

            paspNumbEditText.setText(item.passportNumbers)
            paspNumbEditText.doOnTextChanged { text, _, _, _ ->
                item.passportNumbers = text.toString()
                paspNumbLayout.checkIsEmpty(text.toString())

            }

            dateEndPaspEditText.setText(item.endDateOfPassport)
            dateEndPaspEditText.doOnTextChanged { text, _, _, _ ->
                item.endDateOfPassport = text.toString()
                dateEndPaspLayout.checkIsEmpty(text.toString())
            }

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