package com.prebunking.game.data.api

import com.prebunking.game.data.api.constants.GUESTS
import com.prebunking.game.data.api.model.GuestApiModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface IGuestApi {
    @POST(GUESTS)
    suspend fun createGuest(
        @Body body: CreateGuestBody
    ): Response<GuestApiModel>
}

data class CreateGuestBody(
    val ip: String?,
    val userAgent: String?,
    val country: String?,
    val city: String?
)