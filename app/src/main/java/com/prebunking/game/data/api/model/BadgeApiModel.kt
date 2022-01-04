package com.prebunking.game.data.api.model

import com.prebunking.game.data.model.DomainSerializable
import com.prebunking.game.domain.entity.BadgeEntity

class BadgeApiModel(
    private val id: Int,
    private val name: String,
    private val description: String?,
    private val icon: String
) : DomainSerializable<BadgeEntity> {
    override fun toDomain(): BadgeEntity = BadgeEntity(
        id, name, description, icon
    )
}