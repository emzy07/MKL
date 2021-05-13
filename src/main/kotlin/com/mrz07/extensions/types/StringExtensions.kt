@file:Suppress("NOTHING_TO_INLINE")

package com.mrz07.extensions.types

import com.emzy07.mkl.global.utils.randomIndex
import com.emzy07.mkl.global.variables.fileSeperator
import com.emzy07.mkl.global.variables.lineSeperator

fun String.splitLines() = split(lineSeperator)
fun String.remove(substring: String) = replace(substring, "")

fun String.replaceLast(oldValue: String, newValue: String, ignoreCase: Boolean = false): String {
    val lastIndex = this.lastIndexOf(oldValue)
    if (lastIndex < 0) return this
    val tail = this.substring(lastIndex).replaceFirst(oldValue.toRegex(), newValue)
    return this.substring(0, lastIndex) + tail
}

fun String.doBreak(times: Int = 1): String {
    require(times > 0)
    var breaks = ""
    for (i in 1..times)
        breaks += lineSeperator

    return this + breaks
}

fun String.surrounded(string: String) = string + this + string

fun String.shuffled(): String {
    if (this.countUniqueChars() <= 1) {
        println("Shuffle Error: " + this.quoted())
        return this
    }

    var wort = this
    var shuffleWord = ""

    while (wort.isNotEmpty()) {
        val index = randomIndex(wort.length)
        shuffleWord += wort[index]
        wort = wort.removeCharAt(index)
    }

    return if (this == shuffleWord)// Seltener Fall das trotz shuffle gleiches Wort rauskommt
        this.shuffled()
    else
        shuffleWord
}

fun CharSequence.containsWhitespace(): Boolean {
    if (this.isEmpty())
        return false

    forEach { c ->
        if (Character.isWhitespace(c)) {
            return true
        }
    }
    return false
}

fun String.countUniqueChars() = this.toCharArray().distinct().size

fun String.quoted(): String = "'$this'"
fun String.doubleQuoted(): String = "\"" + this + "\""

fun String.removeCharAt(index: Int) = this.removeRange(index, index + 1)

inline operator fun String.div(other: String) {
    this + fileSeperator + other
}