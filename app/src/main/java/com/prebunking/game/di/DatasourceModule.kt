package com.prebunking.game.di

import com.prebunking.game.data.datasource.CharacterRemoteDataSourceImpl
import com.prebunking.game.data.datasource.ICharacterRemoteDataSource
import com.prebunking.game.data.datasource.IScreenRemoteDataSource
import com.prebunking.game.data.datasource.ScreenRemoteDataSourceImpl
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
}