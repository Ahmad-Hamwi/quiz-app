package com.prebunking.game.data.repository

import com.prebunking.game.domain.entity.CharacterEntity
import com.prebunking.game.domain.gateway.repository.ICharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharacterRepositoryImpl : ICharacterRepository {
    override fun getCharacters(): Flow<List<CharacterEntity>> {
        return flow {};
    }
}