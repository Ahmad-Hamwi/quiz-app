package com.prebunking.game.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.size
import com.prebunking.game.R

class ZigZagBadgesList constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int,
    defStyleRes: Int,
    var verticalLimit: Int = 3
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : this(
        context,
        attrs,
        defStyle,
        0
    )

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context) : this(context, null)

    private var list1: LinearLayout = findViewById(R.id.zigzag_vertical_list_1)
    private var list2: LinearLayout = findViewById(R.id.zigzag_vertical_list_2)

    public fun addBadge(@DrawableRes badgeId: Int) {

        val imageView = AppCompatImageView(context).apply {
            setImageResource(badgeId)
            layoutParams =
                LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        }

        list1.takeIf { size != verticalLimit }?.addView(imageView)
        list2.takeIf { list1.size != verticalLimit && size != verticalLimit }?.addView(imageView)

        if (list1.size != verticalLimit) throw NotImplementedError()
    }
}