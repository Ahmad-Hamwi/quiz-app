package com.prebunking.game.domain.entity

class BadgeEntity (
    private val id: Int,
    private val name: String,
    private val description: String?,
    private val icon: String
) : Entity()