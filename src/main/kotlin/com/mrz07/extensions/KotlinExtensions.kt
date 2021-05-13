@file:Suppress("NOTHING_TO_INLINE")

package com.mrz07.extensions

// To force exhaustive on when operator
val <T> T.exhaustive: T
    get() = this