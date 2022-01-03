package com.prebunking.game.domain.interactor

import kotlinx.coroutines.flow.Flow

abstract class UseCase {
    abstract suspend fun execute()
}

abstract class ParamUseCase<T> {
    abstract suspend fun execute(params: T)
}

abstract class FlowUseCase<RETURN> {
    abstract fun execute(): Flow<RETURN>
}

abstract class ParamFlowUseCase<PARAM, RETURN> {
    abstract fun execute(param: PARAM): Flow<RETURN>
}