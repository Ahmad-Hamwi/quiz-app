package com.prebunking.game.data.repository

import com.prebunking.game.data.datasource.cache.GlideCacheDataSource
import com.prebunking.game.data.datasource.remote.ICharacterRemoteDataSource
import com.prebunking.game.domain.entity.CharacterEntity
import com.prebunking.game.domain.gateway.repository.ICharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepositoryImpl @Inject constructor(
    private val remoteDataSource: ICharacterRemoteDataSource,
    private val glideCacheDataSource: GlideCacheDataSource
) : ICharacterRepository {
    override fun getCharacters(): Flow<List<CharacterEntity>> = remoteDataSource.getCharacters()
        .onEach { list -> list.onEach { glideCacheDataSource.cacheImage(it.profilePicture!!) } }
        .map { it.map { item -> item.toDomain() } }
}