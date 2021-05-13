@file:Suppress("NOTHING_TO_INLINE")

package com.mrz07.extensions.types

import java.io.*
import java.nio.charset.Charset

/**
 * Created by musti on 21.03.18.
 */

fun Reader.readList(): List<String> = BufferedReader(this).lineSequence().toList()

fun InputStream.readList(charset: Charset = Charsets.UTF_8): List<String> = this.reader(charset).readList()

fun File.readList(charset: Charset = Charsets.UTF_8): List<String> = FileInputStream(this).readList(charset)