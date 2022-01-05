package com.prebunking.game.data.repository

import com.prebunking.game.data.datasource.cache.ISessionCacheDataSource
import com.prebunking.game.data.datasource.remote.ISessionRemoteDataSource
import com.prebunking.game.domain.entity.SessionEntity
import com.prebunking.game.domain.gateway.repository.ISessionRepository
import com.prebunking.game.domain.interactor.session.PostSession
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionRepositoryImpl @Inject constructor(
    private val remoteDataSource: ISessionRemoteDataSource,
    private val cacheDataSource: ISessionCacheDataSource,
) : ISessionRepository {
    override fun create(guestId: String, characterId: Int): Flow<SessionEntity> =
        remoteDataSource.createSession(guestId, characterId)
            .onEach { cacheDataSource.cacheId(it.id) }
            .map { it.toDomain() }

    override fun post(postSessionParams: PostSession.PostSessionParams) =
        remoteDataSource.postSession(
            cacheDataSource.getId()!!,
            postSessionParams.postId,
            postSessionParams.isCorrect
        )

}