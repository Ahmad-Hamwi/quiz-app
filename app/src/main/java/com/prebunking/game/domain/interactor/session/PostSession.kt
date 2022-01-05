package com.prebunking.game.domain.interactor.session

import com.prebunking.game.domain.gateway.repository.ISessionRepository
import com.prebunking.game.domain.interactor.ParamUseCase
import kotlinx.coroutines.flow.single

class PostSession(
    private val sessionRepository: ISessionRepository
) : ParamUseCase<PostSession.PostSessionParams>() {
    override suspend fun execute(postSessionParams: PostSessionParams) {
        sessionRepository.post(postSessionParams).single()
    }

    class PostSessionParams(
        val postId: String,
        val isCorrect: Boolean
    )
}