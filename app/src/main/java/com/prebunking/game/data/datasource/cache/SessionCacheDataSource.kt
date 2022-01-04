package com.prebunking.game.data.datasource.cache

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

interface ISessionCacheDataSource {
    fun cacheId(id: String)

    fun getId(): String?
}

@Singleton
class SessionCacheDataSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : ISessionCacheDataSource {
    override fun cacheId(id: String) {
        sharedPreferences.edit().apply {
            putString(SESSION_ID_PREFS_KEY, id)
            apply()
        }
    }

    override fun getId(): String? = sharedPreferences.getString(SESSION_ID_PREFS_KEY, null)

}