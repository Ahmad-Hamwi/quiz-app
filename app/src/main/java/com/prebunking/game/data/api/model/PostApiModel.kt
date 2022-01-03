package com.prebunking.game.data.api.model

import com.prebunking.game.data.model.DomainSerializable
import com.prebunking.game.domain.entity.PostEntity
import com.prebunking.game.domain.entity.PostTypeEntity


class PostApiModel(
    private val id: String,
    private val characterId: Int,
    private val post: String,
    private val postPicture: String,
    private val confirmationQuestion: String,
    private val btnTrue: String,
    private val btnFalse: String,
    private val isTrue: Boolean,
    private val correctAnswerText: String,
    private val wrongAnswerText: String,
    private val character: CharacterApiModel,
    private val badge: BadgeApiModel,
    private val commentsCount: Int,
    private val retweetCount: Int,
    private val likesCount: String,
    private val typeEntity: String
) : DomainSerializable<PostEntity> {
    override fun toDomain(): PostEntity = PostEntity(
        id,
        characterId,
        post,
        postPicture,
        confirmationQuestion,
        btnTrue,
        btnFalse,
        isTrue,
        correctAnswerText,
        wrongAnswerText,
        character.toDomain(),
        badge.toDomain(),
        commentsCount,
        retweetCount,
        likesCount,
        PostTypeEntity.valueOf(typeEntity)
    )

}