@file:Suppress("NOTHING_TO_INLINE")

package com.mrz07.extensions.types.collections

import com.emzy07.mkl.global.utils.randomNumber


inline fun <reified T> Array<T>.shuffle(): Array<T> {
    return apply {
        for (i in size downTo 2)
            swap(i - 1, randomNumber(0, size - 1))
    }
}

fun <T> Array<T>.swap(i: Int, j: Int): Array<T> {
    return apply {
        val aux = this[i]
        this[i] = this[j]
        this[j] = aux
    }
}