package com.prebunking.game.data.repository

import com.prebunking.game.data.datasource.cache.IGuestCacheDataSource
import com.prebunking.game.data.datasource.remote.IGeoLocationRemoteDataSource
import com.prebunking.game.data.datasource.remote.IGuestRemoteDataSource
import com.prebunking.game.data.util.Utils
import com.prebunking.game.domain.entity.GuestEntity
import com.prebunking.game.domain.gateway.repository.IGuestRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GuestRepositoryImpl @Inject constructor(
    private val geoLocationRemoteDataSource: IGeoLocationRemoteDataSource,
    private val remoteDataSource: IGuestRemoteDataSource,
    private val cacheDataSource: IGuestCacheDataSource,
) : IGuestRepository {
    override fun create(): Flow<GuestEntity> =
        geoLocationRemoteDataSource.getGetLocation()
            .catch {
                remoteDataSource.createGuest()
                    .onEach { cacheDataSource.cacheId(it.id) }
                    .map { it.toDomain() }
            }
            .flatMapConcat { geoLocation ->
                remoteDataSource.createGuest(
                    geoLocation.ip,
                    Utils.getDeviceName(),
                    geoLocation.countryName,
                    geoLocation.city,
                )
                    .onEach { cacheDataSource.cacheId(it.id) }
                    .map { it.toDomain() }
            }


}