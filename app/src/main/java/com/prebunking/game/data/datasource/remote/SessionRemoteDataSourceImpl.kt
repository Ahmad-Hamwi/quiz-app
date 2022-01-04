package com.prebunking.game.data.datasource.remote

import com.prebunking.game.data.api.ISessionApi
import com.prebunking.game.data.api.exception.ServerException
import com.prebunking.game.data.api.model.SessionApiModel
import com.prebunking.game.data.api.requests.CreateSessionBody
import com.prebunking.game.data.api.requests.PostSessionBody
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

interface ISessionRemoteDataSource {
    fun createSession(guestId: String, characterId: Int): Flow<SessionApiModel>

    fun postSession(postId: String, isCorrect: Boolean): Flow<Boolean>
}

@Singleton
class SessionRemoteDataSourceImpl @Inject constructor(
    private val sessionsApi: ISessionApi
) : ISessionRemoteDataSource {
    override fun createSession(guestId: String, characterId: Int) = flow {
        val response = sessionsApi.createSession(
            CreateSessionBody(guestId, characterId)
        )
        if (response.isSuccessful) {
            emit(response.body()!!)
        } else {
            if (response.code() == 500) throw ServerException()
            else throw NotImplementedError()
        }
    }

    override fun postSession(postId: String, isCorrect: Boolean): Flow<Boolean> = flow {
        val response = sessionsApi.postSession(PostSessionBody(postId, isCorrect))
        if (response.isSuccessful) {
            emit(true)
        } else {
            if (response.code() == 500) throw ServerException()
            else throw NotImplementedError()
        }
    }

}