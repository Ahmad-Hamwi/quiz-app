package com.prebunking.game.domain.interactor.guest

import com.prebunking.game.domain.gateway.repository.IGuestRepository
import com.prebunking.game.domain.interactor.UseCase
import kotlinx.coroutines.flow.single

class CreateGuest(
    private val guestRepository: IGuestRepository
) : UseCase() {
    override suspend fun execute() {
        guestRepository.create().single()
    }
}