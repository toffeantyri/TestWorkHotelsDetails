package com.testwork.data.models.remote.numbers

import com.squareup.moshi.Json

data class RemoteNumbersDto(
    @field:Json(name = "rooms") val rooms: List<Room?>?
)