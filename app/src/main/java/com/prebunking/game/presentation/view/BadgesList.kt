package com.prebunking.game.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.Space
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.size
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.prebunking.game.R
import com.prebunking.game.databinding.ItemBadgeBinding
import com.prebunking.game.domain.entity.BadgeEntity

class BadgesList constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int,
    defStyleRes: Int
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : this(
        context,
        attrs,
        defStyle,
        0
    )

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context) : this(context, null)

    init {
        inflate(context, R.layout.badges_list, this)
    }

    private var list1: LinearLayoutCompat = findViewById(R.id.badge_list_1)
    private var list2: LinearLayoutCompat = findViewById(R.id.badge_list_2)

    fun withBadges(badges: List<BadgeEntity>) {
        list1.removeAllViews()
        list2.removeAllViews()
        val badgesSrc: MutableList<String> = mutableListOf()
        for (badge in badges) {
            badgesSrc.add(badge.icon)
        }

        // Inflate badges
        for (i in badgesSrc.indices) {
            val binding: ItemBadgeBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.item_badge,
                this,
                false
            )

            binding.src = badgesSrc[i]

            if (i < if (badgesSrc.size.mod(2) == 0) {(badgesSrc.size) / 2} else (badgesSrc.size + 1) / 2) {
                list1.addView(binding.root)
            } else {
                list2.addView(binding.root)
            }
        }
    }
}