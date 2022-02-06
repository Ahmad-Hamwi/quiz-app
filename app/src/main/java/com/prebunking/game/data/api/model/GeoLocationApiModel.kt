package com.prebunking.game.data.api.model

import com.google.gson.annotations.SerializedName

data class GeoLocationApiModel(
    @SerializedName("country_code") val countryCode: String?,
    @SerializedName("country_name") val countryName: String?,
    @SerializedName("city") val city: String?,
    @SerializedName("IPv4") val ip: String?,
)