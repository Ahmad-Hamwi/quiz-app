package com.prebunking.game.presentation.util

import android.app.Activity
import android.graphics.Color
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_COMPACT
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("visibility")
fun visibility(view: View, visibility: Boolean) {
    view.visibility = if (visibility) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("existence")
fun existence(view: View, visibility: Boolean) {
    view.visibility = if (visibility) View.VISIBLE else View.GONE
}

@BindingAdapter("applySystemBarsInsetOnPadding")
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

@BindingAdapter("applySystemBarInsetOnPadding")
fun applySystemBarInsetOnPadding(view: View, addedPaddingTop: Float) {
    ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
        val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
        view.updatePadding(top = addedPaddingTop.toInt() + insets.top)
        windowInsets
    }
}

@BindingAdapter("applyNavBarInsetOnPadding")
fun applyNavBarInsetOnPadding(view: View, addedPaddingBottom: Float) {
    ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
        val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
        view.updatePadding(bottom = addedPaddingBottom.toInt() + insets.bottom)
        windowInsets
    }
}

@BindingAdapter("setDecorFitSystemWindow")
fun setDecorFitSystemWindow(view: View, apply: Boolean) {
    if (!apply) return
    if (view.context is Activity) {
        WindowCompat.setDecorFitsSystemWindows((view.context as Activity).window, false)
    }
}

@BindingAdapter("android:textColor")
fun setHexStringAsTextColor(textView: TextView, hexColor: String?) {
    if (hexColor == null) return
    textView.setTextColor(Color.parseColor("#$hexColor"))
}

@BindingAdapter("android:htmlText")
fun setHtmlText(textView: TextView, htmlText: String?) {
    if (htmlText == null) return
    textView.text = HtmlCompat.fromHtml(htmlText, FROM_HTML_MODE_COMPACT)
}

@BindingAdapter("scrollable")
fun setTextViewScrollable(textView: TextView, scrollable: Boolean) {
    if (!scrollable) return
    textView.movementMethod = ScrollingMovementMethod()
}

@BindingAdapter("loadGlide")
fun loadGlide(imageView: ImageView, imageUrl: String?) {
    if (imageUrl == null) return
    Glide.with(imageView.context)
        .load(imageUrl)
        .fitCenter()
        .into(imageView)
}