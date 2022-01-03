package com.prebunking.game.data.datasource.remote

import com.prebunking.game.data.api.IScreenApi
import com.prebunking.game.data.api.exception.ServerException
import com.prebunking.game.data.api.model.ScreenApiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

interface IScreenRemoteDataSource {
    fun getScreens(): Flow<List<ScreenApiModel>>
}

@Singleton
class ScreenRemoteDataSourceImpl @Inject constructor(
    private val screenApi: IScreenApi
) : IScreenRemoteDataSource {
    override fun getScreens(): Flow<List<ScreenApiModel>> = flow {
        val response = screenApi.getScreens()

        if (response.isSuccessful) {
            emit(response.body()!!.data!!)
        } else {
            if (response.code() == 500) throw ServerException()
            else throw NotImplementedError()
        }
    }

}