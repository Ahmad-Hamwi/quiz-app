package com.prebunking.game.data.repository

import com.prebunking.game.data.datasource.cache.IGuestCacheDataSource
import com.prebunking.game.data.datasource.remote.IGuestRemoteDataSource
import com.prebunking.game.domain.entity.GuestEntity
import com.prebunking.game.domain.gateway.repository.IGuestRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GuestRepositoryImpl @Inject constructor(
    private val remoteDataSource: IGuestRemoteDataSource,
    private val cacheDataSource: IGuestCacheDataSource,
) : IGuestRepository {
    override fun create(): Flow<GuestEntity> = remoteDataSource.createGuest()
        .onEach { cacheDataSource.cacheId(it.id) }
        .map { it.toDomain() }

}