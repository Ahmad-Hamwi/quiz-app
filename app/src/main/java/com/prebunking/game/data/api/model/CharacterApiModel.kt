package com.prebunking.game.data.api.model

import com.prebunking.game.data.model.DomainSerializable
import com.prebunking.game.domain.entity.CharacterEntity

class CharacterApiModel(
    val id: Int?,
    val code: String?,
    val username: String?,
    val fullName: String?,
    val colorHEX: String?,
    val profession: String?,
    val bio: String?,
    val characterPicture: String?,
    val profilePicture: String?,
    val finalText: String?,
) : DomainSerializable<CharacterEntity> {

    override fun toDomain(): CharacterEntity = CharacterEntity(
        id,
        fullName,
        colorHEX,
        profession,
        bio,
        characterPicture,
        profilePicture
    )
}