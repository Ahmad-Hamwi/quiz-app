package com.prebunking.game.presentation.model

import android.graphics.drawable.Drawable
import com.prebunking.game.domain.entity.CharacterEntity
import com.prebunking.game.presentation.util.DrawableUtil

class CharacterUI(
    val id: Int?,
    val fullName: String?,
    val color: String?,
    val profession: String?,
    val bio: String?,
    private val imgFull: String?,
    private val imgProfile: String?,
) {
    val imgFullDrawable: Drawable = DrawableUtil.createDrawableFromUrl(imgFull!!)
    val imgProfileDrawable: Drawable = DrawableUtil.createDrawableFromUrl(imgProfile!!)

    companion object {
        fun fromDomain(domainEntity: CharacterEntity): CharacterUI = CharacterUI(
            domainEntity.id,
            domainEntity.fullName,
            domainEntity.color,
            domainEntity.profession,
            domainEntity.bio,
            domainEntity.imgFull,
            domainEntity.imgProfile
        )
    }
}