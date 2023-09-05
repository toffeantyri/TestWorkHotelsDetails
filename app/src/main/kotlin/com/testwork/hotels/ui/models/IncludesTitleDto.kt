package com.testwork.hotels.ui.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.testwork.domain.models.DelegateAdapterItem

data class IncludesTitleDto(
    @DrawableRes val icon: Int,
    @StringRes val title: Int,
    @StringRes val desc: Int
) : DelegateAdapterItem {
    override fun id(): Any {
        return title
    }

    override fun content(): Any {
        return this
    }
}
