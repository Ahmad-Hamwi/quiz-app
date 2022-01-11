package com.prebunking.game.data.api.model

import com.prebunking.game.data.model.DomainSerializable
import com.prebunking.game.domain.entity.BadgeEntity

class BadgeApiModel(
    val id: Int,
    val name: String,
    val description: String?,
    val icon: String
) : DomainSerializable<BadgeEntity> {
    override fun toDomain(): BadgeEntity = BadgeEntity(
        id, name, description, icon
    )
}