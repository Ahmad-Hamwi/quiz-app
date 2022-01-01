package com.prebunking.game.domain.gateway.repository

import com.prebunking.game.domain.entity.ScreenEntity
import kotlinx.coroutines.flow.Flow

interface IScreenRepository {
    fun getScreens(): Flow<List<ScreenEntity>>
}