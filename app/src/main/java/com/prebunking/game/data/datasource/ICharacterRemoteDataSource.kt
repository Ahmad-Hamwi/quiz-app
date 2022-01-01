package com.prebunking.game.data.datasource

import com.prebunking.game.data.api.ICharacterApi
import com.prebunking.game.data.api.exception.ServerException
import com.prebunking.game.data.api.model.CharacterApiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

interface ICharacterRemoteDataSource {
    fun getCharacters(): Flow<List<CharacterApiModel>>
}

@Singleton
class CharacterRemoteDataSourceImpl @Inject constructor(
    private val characterApi: ICharacterApi
) : ICharacterRemoteDataSource {
    override fun getCharacters(): Flow<List<CharacterApiModel>> = flow {
        val response = characterApi.getCharacters()

        if (response.isSuccessful) {
            emit(response.body()!!.data!!)
        } else {
            if (response.code() == 500) throw ServerException()
            else throw NotImplementedError()
        }
    }
}