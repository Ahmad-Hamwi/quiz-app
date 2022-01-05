package com.prebunking.game.presentation.ui.progress

import androidx.viewpager2.widget.ViewPager2

class ViewPagerPageChangeListener(
    private val onPageSelected: (position: Int) -> Unit
) : ViewPager2.OnPageChangeCallback() {

    override fun onPageSelected(position: Int) {
        this.onPageSelected.invoke(position)
    }
}