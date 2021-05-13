package com.mrz07.global.utils

import com.emzy07.mkl.extensions.types.println
import com.emzy07.mkl.global.variables.lineSeperator
import com.jakewharton.picnic.table
import java.util.concurrent.TimeUnit
import kotlin.time.Duration
import kotlin.time.ExperimentalTime


@ExperimentalTime
inline fun measureDurationOnce(comment: String = "Start MeasureTime:", crossinline action: () -> Unit) {
    measureDuration(comment, 1) { action() }
}

/*
* Measures Code execution time with higher precision by multiple measures.
*/
@ExperimentalTime
inline fun measureDuration(
    comment: String = "Start MeasureDuration: ",
    times: Int = 100000,
    crossinline action: () -> Unit,
): Long {
    require(times > 0) { "MeasureTimes cant be <= 0" }

    println(lineSeperator + comment)

    val nanoSecondsMeasuresList = mutableListOf<Long>()

    for (i in 1..times) {
        val startTime = System.nanoTime()
        action()
        val nanoSeconds = System.nanoTime() - startTime
        nanoSecondsMeasuresList.add(nanoSeconds)
    }

    val averageNanoTime = nanoSecondsMeasuresList.average().toLong()
    val maxNanoTime = nanoSecondsMeasuresList.maxOrNull()!!
    val minNanoTime = nanoSecondsMeasuresList.minOrNull()!!

    // Convert Measures

    val secondMeasures = arrayOf(averageNanoTime, minNanoTime, maxNanoTime).map {
        Duration.convert(
            it.toDouble(),
            TimeUnit.NANOSECONDS,
            TimeUnit.SECONDS
        )
    }
    val millisecondMeasures = arrayOf(averageNanoTime, minNanoTime, maxNanoTime).map {
        Duration.convert(
            it.toDouble(),
            TimeUnit.NANOSECONDS,
            TimeUnit.MILLISECONDS
        )
    }

    // Build Table
    table {
        cellStyle {
            border = true
            paddingLeft = 1
            paddingRight = 1
        }
        row("MeasureDuration: $times", "AVERAGE", "MIN", "MAX")
        row("NANOSECONDS", averageNanoTime, minNanoTime, maxNanoTime)
        row("MILLISECONDS", millisecondMeasures[0], millisecondMeasures[1], millisecondMeasures[2])
        row("SECONDS", secondMeasures[0], secondMeasures[1], secondMeasures[2])
    }.println()

    return nanoSecondsMeasuresList[1]
}