package com.prebunking.game.domain.interactor.session

import com.prebunking.game.domain.entity.GuestEntity
import com.prebunking.game.domain.entity.SessionEntity
import com.prebunking.game.domain.gateway.repository.IGuestRepository
import com.prebunking.game.domain.gateway.repository.ISessionRepository
import com.prebunking.game.domain.interactor.ParamFlowUseCase
import com.prebunking.game.domain.interactor.ParamUseCase
import com.prebunking.game.domain.interactor.UseCase
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMap
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.single
import javax.inject.Singleton

@Singleton
class CreateSession(
    private val guestRepository: IGuestRepository,
    private val sessionRepository: ISessionRepository
) : ParamFlowUseCase<Int, SessionEntity>() {
    override fun execute(characterId: Int): Flow<SessionEntity> =
        guestRepository.create().flatMapConcat { sessionRepository.create(it.id, characterId) }

}
