package com.prebunking.game.data.api

import com.prebunking.game.data.api.model.GeoLocationApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface IGeoLocationApi {
    @GET
    suspend fun getGeoLocation(@Url url: String): Response<GeoLocationApiModel>
}