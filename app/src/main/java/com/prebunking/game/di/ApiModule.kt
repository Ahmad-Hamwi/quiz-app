package com.prebunking.game.di

import com.prebunking.game.data.api.ICharacterApi
import com.prebunking.game.data.api.IGuestApi
import com.prebunking.game.data.api.IScreenApi
import com.prebunking.game.data.api.ISessionApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun provideScreensApi(retrofit: Retrofit): IScreenApi = retrofit.create(IScreenApi::class.java)

    @Provides
    fun provideCharactersApi(retrofit: Retrofit): ICharacterApi =
        retrofit.create(ICharacterApi::class.java)

    @Provides
    fun provideGuestsApi(retrofit: Retrofit): IGuestApi = retrofit.create(IGuestApi::class.java)

    @Provides
    fun provideSessionsApi(retrofit: Retrofit): ISessionApi =
        retrofit.create(ISessionApi::class.java)
}