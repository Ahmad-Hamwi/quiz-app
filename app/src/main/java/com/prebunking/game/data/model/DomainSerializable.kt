package com.prebunking.game.data.model

interface DomainSerializable<T> {

    fun toDomain(): T
}