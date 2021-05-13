package com.mrz07.extensions.types.numbers

import kotlin.math.roundToInt

/**
 * Present Doubles with fixed Digit and round accordingly up or down.
 */
fun Double.roundToFixedDigits(digits: Int): Double {
    require(digits >= 1)
    val factor = Math.pow(10.0, digits.toDouble())
    return (this * factor).roundToInt() / factor
}

/**
 * Round Numbers down cut/ignore the decimals.
 */
fun Double.roundDownToInt() = this.toInt()

/**
 * Round Numbers up when the Double has decimals.
 */
fun Double.roundUpToInt() = Math.ceil(this).toInt()

fun Double.toPlainString() = this.toBigDecimal().toPlainString()