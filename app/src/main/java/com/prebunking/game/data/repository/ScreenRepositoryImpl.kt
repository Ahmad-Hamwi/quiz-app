package com.prebunking.game.data.repository

import com.prebunking.game.data.datasource.IScreenRemoteDataSource
import com.prebunking.game.domain.entity.ScreenEntity
import com.prebunking.game.domain.gateway.repository.IScreenRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ScreenRepositoryImpl @Inject constructor(
    private val screenRemoteDataSource: IScreenRemoteDataSource
) : IScreenRepository {
    override fun getScreens(): Flow<List<ScreenEntity>> = screenRemoteDataSource.getScreens()
        .map { it.map { item -> item.toDomain() } }
}