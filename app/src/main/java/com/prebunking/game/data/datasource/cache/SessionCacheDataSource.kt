package com.prebunking.game.data.datasource.cache

import android.content.SharedPreferences

interface ISessionCacheDataSource {
    fun cacheId(id: String)

    fun getId(): String?
}

class SessionCacheDataSourceImpl(
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