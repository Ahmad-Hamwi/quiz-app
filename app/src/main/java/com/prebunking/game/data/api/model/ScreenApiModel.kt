package com.prebunking.game.data.api.model

import com.prebunking.game.data.model.DomainSerializable
import com.prebunking.game.domain.entity.ScreenEntity

class ScreenApiModel(
    private val id: Int?,
    private val stage: String?,
    private val step: Int?,
    private val title: String?,
    private val content: String?,
    private val textBeforeBtn: String?,
    private val btnText: String?,
    private val stepWord: String?,
    private val stageWord: String?
) : DomainSerializable<ScreenEntity> {
    override fun toDomain(): ScreenEntity = ScreenEntity(id, title, content, textBeforeBtn, btnText)
}