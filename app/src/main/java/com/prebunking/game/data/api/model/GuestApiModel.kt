package com.prebunking.game.data.api.model

import com.prebunking.game.data.model.DomainSerializable
import com.prebunking.game.domain.entity.GuestEntity

class GuestApiModel(
    val id: String
) : DomainSerializable<GuestEntity> {
    override fun toDomain(): GuestEntity = GuestEntity(id)
}