package com.prebunking.game.domain.entity

class SessionEntity(
    val id: String,
    val posts: List<PostEntity>,
    val badges: List<BadgeEntity>
) : Entity()