package com.prebunking.game.data.datasource.cache

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

interface IGuestCacheDataSource {
    fun cacheId(id: String)

    fun getId(): String?
}

@Singleton
class GuestCacheDataSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : IGuestCacheDataSource {
    override fun cacheId(id: String) {
        sharedPreferences.edit().apply {
            putString(GUEST_ID_PREFS_KEY, id)
            apply()
        }
    }

    override fun getId(): String? = sharedPreferences.getString(GUEST_ID_PREFS_KEY, null)
}