package com.prebunking.game.data.api.model

import com.prebunking.game.data.model.DomainSerializable
import com.prebunking.game.domain.entity.PostEntity
import com.prebunking.game.domain.entity.PostTypeEntity


class PostApiModel(
    val id: String,
    val characterId: Int,
    val post: String,
    val postPicture: String?,
    val confirmationQuestion: String,
    val btnTrue: String,
    val btnFalse: String,
    val isTrue: Boolean,
    val correctAnswerText: String,
    val wrongAnswerText: String,
    val character: CharacterApiModel,
    val badge: BadgeApiModel,
    val commentsCount: Int,
    val retweetCount: Int,
    val likesCount: String,
    val type: String
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
        PostTypeEntity.valueOf(type.uppercase())
    )

}