package com.mrz07.extensions.types.numbers

import java.math.BigInteger

fun BigInteger.fitsInLong(): Boolean = this in (Long.MIN_VALUE.toBigInteger()..Long.MAX_VALUE.toBigInteger())
fun BigInteger.fitsInInt(): Boolean = this in (Int.MIN_VALUE.toBigInteger()..Int.MAX_VALUE.toBigInteger())