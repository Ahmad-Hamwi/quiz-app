package com.prebunking.game.data.repository

import com.prebunking.game.data.datasource.ICharacterRemoteDataSource
import com.prebunking.game.domain.entity.CharacterEntity
import com.prebunking.game.domain.gateway.repository.ICharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepositoryImpl @Inject constructor(
    private val remoteDataSource: ICharacterRemoteDataSource
) : ICharacterRepository {
    override fun getCharacters(): Flow<List<CharacterEntity>> = remoteDataSource.getCharacters()
        .map { it.map { item -> item.toDomain() } }
}