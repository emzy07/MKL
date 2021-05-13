package com.mrz07.helper

data class BitValue internal constructor(val bits: Long) {
    val bytes: Double = bits.toDouble() / 8
    val kibibytes: Double = bytes / 1024
    val kiloBytes: Double = bytes / 1000
    val mebibytes: Double = kibibytes / 1024
    val megaBytes: Double = kiloBytes / 1000
    val gibibytes: Double = mebibytes / 1024
    val gigabytes: Double = megaBytes / 1000
    val tebibytes: Double = gibibytes / 1024
    val terabytes: Double = gigabytes / 1000
    val pebibytes: Double = tebibytes / 1024
    val petabytes: Double = terabytes / 1000

    operator fun plus(other: BitValue) = BitValue(bits + other.bits)
    operator fun minus(other: BitValue) = BitValue(bits - other.bits)
    operator fun times(mult: Long) = BitValue(mult * bits)
    operator fun div(div: Long) = BitValue(bits / div)
    operator fun div(div: BitValue) = bits / div.bits
}