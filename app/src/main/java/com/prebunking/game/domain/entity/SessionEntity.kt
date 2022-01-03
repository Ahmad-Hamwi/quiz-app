package com.prebunking.game.domain.entity

class SessionEntity(
    private val id: String,
    private val posts: List<PostEntity>,
    private val badges: List<BadgeEntity>
) : Entity()