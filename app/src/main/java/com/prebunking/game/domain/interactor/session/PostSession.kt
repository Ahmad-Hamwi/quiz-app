package com.prebunking.game.domain.interactor.session

import com.prebunking.game.domain.gateway.repository.ISessionRepository
import com.prebunking.game.domain.interactor.ParamUseCase
import kotlinx.coroutines.flow.single
import javax.inject.Inject
import javax.inject.Singleton

class PostSession(
    private val sessionRepository: ISessionRepository
) : ParamUseCase<PostSession.Params>() {
    override suspend fun execute(params: Params) {
        sessionRepository.post(params).single()
    }

    inner class Params(
        val postId: String,
        val isCorrect: Boolean
    )
}