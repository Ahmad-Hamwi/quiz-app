package com.prebunking.game.data.api

import com.prebunking.game.data.api.constants.GUESTS
import com.prebunking.game.data.api.model.GuestApiModel
import com.prebunking.game.data.api.model.RemoteResponse
import retrofit2.http.POST

interface IGuestApi {
    @POST(GUESTS)
    suspend fun createGuest(): RemoteResponse<GuestApiModel>
}