package com.prebunking.game.data.api

import com.prebunking.game.data.api.constants.CHARACTERS
import com.prebunking.game.data.api.model.CharacterApiModel
import com.prebunking.game.data.api.model.RemoteResponse
import retrofit2.http.GET

interface ICharacterApi {
    @GET(CHARACTERS)
    suspend fun getCharacters(): RemoteResponse<List<CharacterApiModel>>
}