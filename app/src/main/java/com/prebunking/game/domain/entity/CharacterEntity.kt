package com.prebunking.game.domain.entity

class CharacterEntity (
    val id: Int?,
    val fullName: String?,
    val color: String?,
    val profession: String?,
    val bio: String?,
    val imgFull: String?,
    val imgProfile: String?,
) : Entity()