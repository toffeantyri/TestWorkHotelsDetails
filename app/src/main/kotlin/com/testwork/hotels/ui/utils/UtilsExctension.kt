package com.testwork.hotels.ui.utils

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast

fun Number.toPx() = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    this.toFloat(), Resources.getSystem().displayMetrics
)

fun Context.showToast(message: String?, length: Int = Toast.LENGTH_SHORT) {
    message?.let {
        Toast.makeText(this, it, length).show()
    }
}