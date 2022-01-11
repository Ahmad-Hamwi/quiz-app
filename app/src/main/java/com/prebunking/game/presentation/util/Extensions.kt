package com.prebunking.game.presentation.util

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<MutableList<T>>.add(item: T) {
    val updatedItems = this.value
    updatedItems!!.add(item)
    this.value = updatedItems
}