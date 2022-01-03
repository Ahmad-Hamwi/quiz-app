package com.prebunking.game.domain.gateway.repository

import com.prebunking.game.domain.entity.GuestEntity
import kotlinx.coroutines.flow.Flow

interface IGuestRepository {
    fun create(): Flow<GuestEntity>
}