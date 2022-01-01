package com.prebunking.game.presentation.model

import android.graphics.drawable.Drawable
import androidx.lifecycle.LiveData
import com.prebunking.game.domain.entity.CharacterEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow

class CharacterUI(
    val id: Int?,
    val fullName: String?,
    val color: String?,
    val profession: String?,
    val bio: String?,
    val imgFull: String?,
    val imgProfile: String?,
) {

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