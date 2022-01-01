package com.prebunking.game.data.api

import com.prebunking.game.data.api.constants.SCREENS
import com.prebunking.game.data.api.model.RemoteResponse
import com.prebunking.game.data.api.model.ScreenApiModel
import retrofit2.http.GET

interface IScreenApi {
    @GET(SCREENS)
    suspend fun getScreens(): RemoteResponse<List<ScreenApiModel>>
}