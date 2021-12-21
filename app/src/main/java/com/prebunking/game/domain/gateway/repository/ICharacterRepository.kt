package com.prebunking.game.domain.gateway.repository

import com.prebunking.game.domain.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow

interface ICharacterRepository {
    fun getCharacters(): Flow<List<CharacterEntity>>
}