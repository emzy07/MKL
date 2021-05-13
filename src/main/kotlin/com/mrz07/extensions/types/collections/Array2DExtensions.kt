package com.mrz07.extensions.types.collections

inline val <T> Array<Array<T>>.totalSize get() = fold(0) { acc, col -> acc + col.size }

inline val <T> Array<Array<T>>.rowsSize get() = size