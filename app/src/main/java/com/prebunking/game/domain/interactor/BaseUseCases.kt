package com.prebunking.game.domain.interactor

import kotlinx.coroutines.flow.Flow

abstract class FlowUseCase<RETURN> {
    abstract fun execute(): Flow<RETURN>
}

abstract class ParamFlowUseCase<PARAM, RETURN> {
    abstract fun execute(param: PARAM): Flow<RETURN>
}