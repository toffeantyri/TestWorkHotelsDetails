package com.testwork.domain.models

data class LinkWrapperDto(val link: String) : DelegateAdapterItem {
    override fun id(): Any {
        return link
    }

    override fun content(): Any {
        return this
    }
}
