package com.mrz07.extensions.types.numbers

import java.math.BigDecimal

fun BigDecimal.fitsInDouble(): Boolean = this in (-Double.MAX_VALUE.toBigDecimal()..Double.MAX_VALUE.toBigDecimal())
fun BigDecimal.fitsInFloat(): Boolean = this in (-Float.MAX_VALUE.toBigDecimal()..Float.MAX_VALUE.toBigDecimal())