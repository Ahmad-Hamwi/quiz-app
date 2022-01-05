package com.prebunking.game.domain.entity

class BadgeEntity (
    val id: Int,
    val name: String,
    val description: String?,
    val icon: String
) : Entity()