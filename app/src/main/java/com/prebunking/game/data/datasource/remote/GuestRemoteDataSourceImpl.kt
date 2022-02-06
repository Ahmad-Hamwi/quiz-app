package com.prebunking.game.data.datasource.remote

import com.prebunking.game.data.api.CreateGuestBody
import com.prebunking.game.data.api.IGuestApi
import com.prebunking.game.data.api.exception.ServerException
import com.prebunking.game.data.api.model.GuestApiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

interface IGuestRemoteDataSource {
    fun createGuest(
        ip: String? = null,
        userAgent: String? = null,
        country: String? = null,
        city: String? = null
    ): Flow<GuestApiModel>
}

@Singleton
class GuestRemoteDataSourceImpl @Inject constructor(
    private val guestApi: IGuestApi
) : IGuestRemoteDataSource {
    override fun createGuest(
        ip: String?,
        userAgent: String?,
        country: String?,
        city: String?
    ): Flow<GuestApiModel> = flow {
        val response = guestApi.createGuest(CreateGuestBody(ip, userAgent, country, city))

        if (response.isSuccessful) {
            emit(response.body()!!)
        } else {
            if (response.code() == 500) throw ServerException()
            else throw NotImplementedError()
        }
    }

}