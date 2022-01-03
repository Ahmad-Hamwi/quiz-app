package com.prebunking.game.domain.interactor.session

import com.prebunking.game.domain.entity.GuestEntity
import com.prebunking.game.domain.gateway.repository.IGuestRepository
import com.prebunking.game.domain.gateway.repository.ISessionRepository
import com.prebunking.game.domain.interactor.ParamUseCase
import com.prebunking.game.domain.interactor.UseCase
import kotlinx.coroutines.flow.single
import javax.inject.Singleton

@Singleton
class CreateSession(
    private val guestRepository: IGuestRepository,
    private val sessionRepository: ISessionRepository
) : ParamUseCase<Int>() {
    override suspend fun execute(characterId: Int) {
        val guest: GuestEntity = guestRepository.create().single()
        sessionRepository.create(guest.id, characterId).single()
    }
}