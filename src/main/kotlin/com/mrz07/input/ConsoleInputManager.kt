package com.mrz07.input

import com.emzy07.mkl.extensions.types.println
import com.emzy07.mkl.extensions.types.quoted
import com.emzy07.mkl.extensions.types.surrounded
import com.emzy07.mkl.extensions.validator.isValidInteger
import com.emzy07.mkl.global.variables.lineSeperator
import kotlin.math.absoluteValue

object ConsoleInputManager {

    fun readString(prompt: String?): String {

        while (true) {
            prompt?.println()
            val input = readLine()
            if (!input.isNullOrBlank())
                return input
        }

    }

    fun readInteger(prompt: String?): Int {
        while (true) {
            val input = readString(prompt)
            try {
                return Integer.parseInt(input)
            } catch (e: NumberFormatException) {
                if (input.isValidInteger()) {
                    val negative = input.startsWith("-")
                    println("Error: Input: ${input.quoted()} is to ${if (negative) "small" else "big"} please use the Range ${Integer.MIN_VALUE} - ${Integer.MAX_VALUE}")
                } else
                    println("Error: Input: " + input.quoted() + " is not a valid Integer!\nPlease enter only numbers without special characters or letters")
            }

        }
    }

    fun readPositiveInteger(prompt: String?): Int {
        while (true) {
            val number = readInteger(prompt)
            if (number > 0)
                return number
            else
                println("Error: The entered number must be greater than 0")
        }
    }

    fun readIntegerBetween(prompt: String?, min: Int, max: Int): Int {
        while (true) {
            val number = readInteger(prompt)
            if (number in min..max)
                return number
            else
                println("Error: The entered number must be between $min - $max")
        }
    }

    fun readDecisionResponse(
        question: String,
        yesChoices: Array<String>,
        noChoices: Array<String>,
        invalidAnswerMessage: String
    ): Boolean {
        while (true) {
            val input = readString(question)

            for (yes in yesChoices)
                if (input.equals(yes, ignoreCase = true))
                    return true

            for (no in noChoices)
                if (input.equals(no, ignoreCase = true))
                    return false

            println("Error: $invalidAnswerMessage")
        }
    }

    fun readYesNoChoice(question: String) = readDecisionResponse(
        question,
        arrayOf("Yes", "Y"),
        arrayOf("No", "N"),
        "Invalid Answer: please enter only ${"Yes".quoted()} or ${"No".quoted()}"
    )

    // Cancel will be always the last Entry and get the choice 0
    fun makeMenu(showCancel: Boolean, vararg menuPoints: String): Int {
        print("Please choose:".surrounded(lineSeperator))

        val menuPointMaxLength = menuPoints.maxOrNull()!!.length

        for (i in menuPoints.indices) {
            val lastEntry = i == menuPoints.size - 1 && showCancel

            val line =
                (if (lastEntry) lineSeperator else "") + menuPoints[i] + " ".repeat((menuPointMaxLength - menuPoints[i].length).absoluteValue + 1) + if (lastEntry) 0 else i + 1
            println(line)
        }

        val prompt = lineSeperator + "Your Choice ? "
        return if (showCancel)
            readIntegerBetween(prompt, 0, menuPoints.size - 1)
        else
            readIntegerBetween(prompt, 1, menuPoints.size)
    }

}