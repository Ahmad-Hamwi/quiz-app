package com.prebunking.game.domain.entity

class PostEntity(
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
    val character: CharacterEntity,
    val badge: BadgeEntity,
    val commentsCount: Int,
    val retweetCount: Int,
    val likesCount: String,
    val typeEntity: PostTypeEntity
) : Entity()