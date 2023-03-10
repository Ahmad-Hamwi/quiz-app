package com.prebunking.game.domain.interactor.character

import com.prebunking.game.domain.entity.CharacterEntity
import com.prebunking.game.domain.gateway.repository.ICharacterRepository
import com.prebunking.game.domain.interactor.FlowUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

class GetCharacters constructor(
    private val characterRepository: ICharacterRepository
) : FlowUseCase<List<CharacterEntity>>() {

    override fun execute(): Flow<List<CharacterEntity>> = characterRepository.getCharacters()

}