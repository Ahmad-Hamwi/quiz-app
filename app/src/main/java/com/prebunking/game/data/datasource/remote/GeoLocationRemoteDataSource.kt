package com.prebunking.game.data.datasource.remote

import com.prebunking.game.data.api.IGeoLocationApi
import com.prebunking.game.data.api.constants.GEO_LOCATION
import com.prebunking.game.data.api.exception.ServerException
import com.prebunking.game.data.api.model.GeoLocationApiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

interface IGeoLocationRemoteDataSource {
    fun getGetLocation(): Flow<GeoLocationApiModel>
}

@Singleton
class GeoLocationRemoteDataSource @Inject constructor(
    private val geoLocationApiApi: IGeoLocationApi
) : IGeoLocationRemoteDataSource {
    override fun getGetLocation(): Flow<GeoLocationApiModel> = flow {
        val response = geoLocationApiApi.getGeoLocation(GEO_LOCATION)

        if (response.isSuccessful) {
            emit(response.body()!!)
        } else {
            if (response.code() == 500) throw ServerException()
            else throw NotImplementedError()
        }
    }

}