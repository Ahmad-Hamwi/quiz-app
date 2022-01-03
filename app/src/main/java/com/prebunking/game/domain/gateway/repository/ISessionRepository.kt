package com.prebunking.game.domain.gateway.repository

import com.prebunking.game.domain.entity.SessionEntity
import com.prebunking.game.domain.interactor.session.PostSession
import kotlinx.coroutines.flow.Flow

interface ISessionRepository {
    fun create(guestId: String, characterId: Int): Flow<SessionEntity>

    fun post(params: PostSession.Params): Flow<Boolean>
}