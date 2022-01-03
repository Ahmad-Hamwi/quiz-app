package com.prebunking.game.di

import com.prebunking.game.data.datasource.cache.GuestCacheDataSourceImpl
import com.prebunking.game.data.datasource.cache.IGuestCacheDataSource
import com.prebunking.game.data.datasource.cache.ISessionCacheDataSource
import com.prebunking.game.data.datasource.cache.SessionCacheDataSourceImpl
import com.prebunking.game.data.datasource.remote.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DatasourceModule {

    @Binds
    abstract fun bindScreenRemoteDataSource(screenRemoteDataSourceImpl: ScreenRemoteDataSourceImpl): IScreenRemoteDataSource

    @Binds
    abstract fun bindCharacterRemoteDataSource(characterRemoteDataSourceImpl: CharacterRemoteDataSourceImpl): ICharacterRemoteDataSource

    @Binds
    abstract fun bindGuestRemoteDataSource(guestRemoteDataSourceImpl: GuestRemoteDataSourceImpl): IGuestRemoteDataSource

    @Binds
    abstract fun bindSessionRemoteDataSource(sessionRemoteDataSourceImpl: SessionRemoteDataSourceImpl): ISessionRemoteDataSource

    @Binds
    abstract fun bindGuestCacheDataSource(guestCacheDataSourceImpl: GuestCacheDataSourceImpl): IGuestCacheDataSource

    @Binds
    abstract fun bindSessionCacheDataSource(sessionCacheDataSourceImpl: SessionCacheDataSourceImpl): ISessionCacheDataSource
}