package com.testwork.domain.models.pres_model

import com.testwork.domain.models.DelegateAdapterItem

data class LinkWrapperDto(val link: String) : DelegateAdapterItem {
    override fun id(): Any {
        return link
    }

    override fun content(): Any {
        return this
    }
}
