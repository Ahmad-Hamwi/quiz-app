package com.prebunking.game.domain.interactor.screen

import com.prebunking.game.domain.entity.ScreenEntity
import com.prebunking.game.domain.gateway.repository.IScreenRepository
import com.prebunking.game.domain.interactor.FlowUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

class GetScreens constructor(
    private val screenRepo: IScreenRepository
) : FlowUseCase<List<ScreenEntity>>() {
    override fun execute(): Flow<List<ScreenEntity>> = screenRepo.getScreens()
}