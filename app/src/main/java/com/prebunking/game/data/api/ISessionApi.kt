package com.prebunking.game.data.api

import com.prebunking.game.data.api.constants.SESSIONS
import com.prebunking.game.data.api.constants.SESSIONS_POST
import com.prebunking.game.data.api.model.RemoteResponse
import com.prebunking.game.data.api.model.SessionApiModel
import com.prebunking.game.data.api.requests.CreateSessionBody
import com.prebunking.game.data.api.requests.PostSessionBody
import retrofit2.http.Body
import retrofit2.http.POST

interface ISessionApi {
    @POST(SESSIONS)
    suspend fun createSession(@Body body: CreateSessionBody): RemoteResponse<SessionApiModel>

    @POST(SESSIONS_POST)
    suspend fun postSession(@Body body: PostSessionBody): RemoteResponse<Nothing>
}