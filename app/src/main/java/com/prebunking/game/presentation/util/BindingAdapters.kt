package com.prebunking.game.presentation.util

import android.app.Activity
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.databinding.BindingAdapter

@BindingAdapter("app:visibility")
fun visibility(view: View, visibility: Boolean) {
    view.visibility = if (visibility) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("app:existence")
fun existence(view: View, visibility: Boolean) {
    view.visibility = if (visibility) View.VISIBLE else View.GONE
}

@BindingAdapter("app:applySystemBarsInsetOnPadding")
fun applySystemBarsInsetOnPadding(view: View, addedPaddingVertical: Float) {
    ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
        val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
        view.updatePadding(
            bottom = addedPaddingVertical.toInt() + insets.bottom,
            top = addedPaddingVertical.toInt() + insets.top
        )
        windowInsets
    }
}

@BindingAdapter("app:applySystemBarInsetOnPadding")
fun applySystemBarInsetOnPadding(view: View, addedPaddingTop: Float) {
    ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
        val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
        view.updatePadding(top = addedPaddingTop.toInt() + insets.top)
        windowInsets
    }
}

@BindingAdapter("app:applyNavBarInsetOnPadding")
fun applyNavBarInsetOnPadding(view: View, addedPaddingBottom: Float) {
    ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
        val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
        view.updatePadding(bottom = addedPaddingBottom.toInt() + insets.bottom)
        windowInsets
    }
}

@BindingAdapter("app:setDecorFitSystemWindow")
fun setDecorFitSystemWindow(view: View, apply: Boolean) {
    if (!apply) return
    if (view.context is Activity) {
        WindowCompat.setDecorFitsSystemWindows((view.context as Activity).window, false)
    }
}