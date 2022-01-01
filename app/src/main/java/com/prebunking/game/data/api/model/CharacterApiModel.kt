package com.prebunking.game.data.api.model

import com.prebunking.game.data.model.DomainSerializable
import com.prebunking.game.domain.entity.CharacterEntity

class CharacterApiModel(
    private val id: Int?,
    private val code: String?,
    private val username: String?,
    private val fullName: String?,
    private val colorHex: String?,
    private val profession: String?,
    private val bio: String?,
    private val characterPicture: String?,
    private val profilePicture: String?,
    private val finalText: String?,
) : DomainSerializable<CharacterEntity> {

    override fun toDomain(): CharacterEntity = CharacterEntity(
        id,
        fullName,
        colorHex,
        profession,
        bio,
        characterPicture,
        profilePicture
    )
}