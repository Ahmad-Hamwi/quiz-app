package com.prebunking.game.di

import android.content.Context
import android.content.SharedPreferences
import com.prebunking.game.data.api.constants.BASE_URL
import com.prebunking.game.data.datasource.cache.GlideCacheDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class UtilModule {

    @Provides
    fun provideRetrofitClient(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideSharedPreferences(
        @ApplicationContext context: Context
    ): SharedPreferences = context.getSharedPreferences("app_cache", Context.MODE_PRIVATE)

    @Provides
    fun provideGlideCacheDataSource(@ApplicationContext context: Context): GlideCacheDataSource =
        GlideCacheDataSource(context)
}