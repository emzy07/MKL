package com.mrz07.utils

import java.io.*


object Serializer {

    fun save(savePath: String, `object`: Any) {
        try {
            val fileOut = FileOutputStream(savePath)
            val out = ObjectOutputStream(fileOut)
            out.writeObject(`object`)
            out.close()
            fileOut.close()
        } catch (i: IOException) {
            i.printStackTrace()
        }

    }

    fun load(loadPath: String, javaClass: Class<*>): Any {

        val fileIn = FileInputStream(loadPath)
        val objectInputStream = ObjectInputStream(fileIn)
        var o: Any? = null
        try {
            o = objectInputStream.readObject() as Class<*>
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }

        objectInputStream.close()
        fileIn.close()

        return o!!
    }

}

