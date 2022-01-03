package com.prebunking.game.data.api.model

import com.prebunking.game.data.model.DomainSerializable
import com.prebunking.game.domain.entity.SessionEntity

class SessionApiModel(
    val id: String,
    val posts: List<PostApiModel>,
    val badges: List<BadgeApiModel>
) : DomainSerializable<SessionEntity> {
    override fun toDomain(): SessionEntity = SessionEntity(
        id, posts.map { it.toDomain() }, badges.map { it.toDomain() }
    )
}