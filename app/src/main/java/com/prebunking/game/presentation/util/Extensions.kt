package com.prebunking.game.presentation.util

import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import coil.util.CoilUtils
import okhttp3.OkHttpClient

fun ImageView.loadUrl(url: String?) {

    val imageLoader = ImageLoader.Builder(this.context)
        .okHttpClient {
            OkHttpClient.Builder()
                .cache(CoilUtils.createDefaultCache(context))
                .build()
        }
        .componentRegistry { add(SvgDecoder(this@loadUrl.context)) }
        .build()

    val request = ImageRequest.Builder(this.context)
        .crossfade(true)
        .crossfade(500)
        .data(url)
        .target(this)
        .build()

    imageLoader.enqueue(request)
}

fun <T> MutableLiveData<MutableList<T>>.add(item: T) {
    val updatedItems = this.value
    updatedItems!!.add(item)
    this.value = updatedItems
}