package com.mrz07.extensions.types.numbers

fun Number.pow(power: Number) = Math.pow(this.toDouble(), power.toDouble())
fun Number.square() = Math.sqrt(this.toDouble())
fun Number.root(root: Number) = pow(1 / root.toDouble())