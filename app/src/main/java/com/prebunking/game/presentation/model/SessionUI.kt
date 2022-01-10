package com.prebunking.game.presentation.model

import androidx.lifecycle.MutableLiveData
import com.prebunking.game.domain.entity.BadgeEntity
import com.prebunking.game.domain.entity.PostEntity
import com.prebunking.game.domain.entity.SessionEntity

class SessionUI(
    val id: String,
    val posts: List<PostEntity>,
    val badges: List<BadgeEntity>,
) {

    val obtainedBadges: MutableLiveData<MutableList<BadgeEntity>> = MutableLiveData(mutableListOf())

    companion object {
        fun fromDomain(sessionEntity: SessionEntity): SessionUI = SessionUI(
            sessionEntity.id,
            sessionEntity.posts,
            sessionEntity.badges
        )
    }
}