@file:Suppress("NOTHING_TO_INLINE", "UNUSED_PARAMETER")

package com.mrz07.extensions.types.collections


inline fun <T> Collection<T?>.anyNull(): Boolean = any { it == null }

inline fun <T> Collection<T>.firstHalf(): List<T> = take(size / 2)
inline fun <T> Collection<T>.secondHalf(): List<T> = drop(size / 2)

inline fun <T> Collection<T>.split(index: Int): Pair<List<T>, List<T>> = take(index) to drop(index)
inline fun <T> Collection<T>.split(): Pair<List<T>, List<T>> = split(size / 2)

inline fun <T> List<T>.encapsulate(): List<List<T>> = map { listOf(it) }

fun <T> MutableList<T>.swap(i: Int, j: Int): MutableList<T> {
    return apply {
        val aux = this[i]
        this[i] = this[j]
        this[j] = aux
    }
}

fun <T> List<T>.swapped(i: Int, j: Int): List<T> = this.toMutableList().swap(i, j)