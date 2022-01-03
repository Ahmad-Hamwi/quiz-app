package com.prebunking.game.di

import com.prebunking.game.data.repository.CharacterRepositoryImpl
import com.prebunking.game.data.repository.GuestRepositoryImpl
import com.prebunking.game.data.repository.ScreenRepositoryImpl
import com.prebunking.game.data.repository.SessionRepositoryImpl
import com.prebunking.game.domain.gateway.repository.ICharacterRepository
import com.prebunking.game.domain.gateway.repository.IGuestRepository
import com.prebunking.game.domain.gateway.repository.IScreenRepository
import com.prebunking.game.domain.gateway.repository.ISessionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun provideCharacterRepository(characterRepositoryImpl: CharacterRepositoryImpl): ICharacterRepository

    @Binds
    abstract fun provideScreenRepository(screenRepositoryImpl: ScreenRepositoryImpl): IScreenRepository

    @Binds
    abstract fun provideSessionRepository(screenRepositoryImpl: SessionRepositoryImpl): ISessionRepository

    @Binds
    abstract fun provideGuestRepository(screenRepositoryImpl: GuestRepositoryImpl): IGuestRepository
}