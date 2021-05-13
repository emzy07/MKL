@file:Suppress("NOTHING_TO_INLINE")

package com.mrz07.extensions.types

import com.emzy07.mkl.global.variables.desktopPath
import java.io.PrintWriter

fun Any?.isNull() = this == null
fun Any?.isNotNull() = this != null
inline fun Any.println() = println(this)

fun Any.saveAsTextFile(filePath: String = desktopPath + "saveAsTextFile.txt", log: Boolean = true): Boolean {

    try {
        val out = PrintWriter(filePath, "UTF-8")
        out.write(this.toString())
        out.close()
        if (log)
            print("The object was successfully saved under the path: $filePath")

        return true
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return false
}