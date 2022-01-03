package com.prebunking.game.di

import com.prebunking.game.domain.gateway.repository.ICharacterRepository
import com.prebunking.game.domain.gateway.repository.IGuestRepository
import com.prebunking.game.domain.gateway.repository.IScreenRepository
import com.prebunking.game.domain.gateway.repository.ISessionRepository
import com.prebunking.game.domain.interactor.character.GetCharacters
import com.prebunking.game.domain.interactor.guest.CreateGuest
import com.prebunking.game.domain.interactor.screen.GetScreens
import com.prebunking.game.domain.interactor.session.CreateSession
import com.prebunking.game.domain.interactor.session.PostSession
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    @Singleton
    fun provideGetScreensUseCase(screensRepository: IScreenRepository): GetScreens =
        GetScreens(screensRepository)

    @Provides
    @Singleton
    fun provideGetCharactersUseCase(charactersRepository: ICharacterRepository): GetCharacters =
        GetCharacters(charactersRepository)

    @Provides
    @Singleton
    fun provideCreateGuestUseCase(guestRepository: IGuestRepository): CreateGuest =
        CreateGuest(guestRepository)

    @Provides
    @Singleton
    fun providePostSessionUseCase(sessionRepository: ISessionRepository): PostSession =
        PostSession(sessionRepository)

    @Provides
    @Singleton
    fun provideCreateSessionUseCase(
        guestRepository: IGuestRepository,
        sessionRepository: ISessionRepository
    ): CreateSession =
        CreateSession(guestRepository, sessionRepository)
}