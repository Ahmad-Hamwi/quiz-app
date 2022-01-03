package com.prebunking.game.domain.entity

class PostEntity(
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
    private val character: CharacterEntity,
    private val badge: BadgeEntity,
    private val commentsCount: Int,
    private val retweetCount: Int,
    private val likesCount: String,
    private val typeEntity: PostTypeEntity
) : Entity()