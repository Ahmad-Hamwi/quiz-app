package com.prebunking.game.data.datasource.cache

import android.content.Context
import com.bumptech.glide.Glide
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GlideCacheDataSource @Inject constructor(
    @ApplicationContext private val context: Context
) {
    fun cacheImage(imageUrl: String) {
        Glide.with(context)
            .load(imageUrl)
            .preload()
    }
}