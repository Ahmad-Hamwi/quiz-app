package com.prebunking.game.data.datasource.remote

import com.prebunking.game.data.api.IGuestApi
import com.prebunking.game.data.api.exception.ServerException
import com.prebunking.game.data.api.model.GuestApiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

interface IGuestRemoteDataSource {
    fun createGuest(): Flow<GuestApiModel>
}

@Singleton
class GuestRemoteDataSourceImpl @Inject constructor(
    private val guestApi: IGuestApi
) : IGuestRemoteDataSource {
    override fun createGuest(): Flow<GuestApiModel> = flow {
        val response = guestApi.createGuest()

        if (response.isSuccessful) {
            emit(response.body()!!.data!!)
        } else {
            if (response.code() == 500) throw ServerException()
            else throw NotImplementedError()
        }
    }

}