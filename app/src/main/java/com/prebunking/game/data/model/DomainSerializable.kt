package com.prebunking.game.data.model

import com.prebunking.game.domain.entity.Entity

interface DomainSerializable<T : Entity> {

    fun toDomain(): T
}