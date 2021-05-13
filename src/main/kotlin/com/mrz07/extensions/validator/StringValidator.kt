package com.mrz07.extensions.validator

fun String.isValidInteger() = this.matches("^[+-]?\\d+$".toRegex()) //+-Number

fun String.containDigits(): Boolean = this.matches(".*\\d+.*".toRegex())