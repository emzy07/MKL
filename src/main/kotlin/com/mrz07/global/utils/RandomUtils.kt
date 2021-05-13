package com.mrz07.global.utils

import java.util.concurrent.ThreadLocalRandom

fun randomNumber(min: Int, max: Int): Int {
    require(max > min) { "RandomNumber generation is impossible because of: max: $max <= min: $min" }
    return ThreadLocalRandom.current().nextInt(min, max + 1)
}

fun randomIndex(size: Int): Int {
    require(size > 0) { "RandomNumber randomIndex cant be <= 0 $size" }

    return if (size == 1)
        0
    else
        randomNumber(0, size - 1)
}

fun chance(zahl: Int): Boolean = randomNumber(1, zahl) == 1

fun chancePercent(percent: Int) = randomNumber(1, percent) <= percent