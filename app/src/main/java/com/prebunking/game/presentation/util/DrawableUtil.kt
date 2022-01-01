package com.prebunking.game.presentation.util

import android.graphics.drawable.Drawable
import java.io.InputStream
import java.lang.Exception
import java.net.URL

class DrawableUtil {
    companion object {
        fun createDrawableFromUrl(url: String): Drawable {
            val inputStream: InputStream = URL(url).content as InputStream
            return Drawable.createFromStream(inputStream, "")
        }
    }
}