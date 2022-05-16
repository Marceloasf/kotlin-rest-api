package br.com.kotlinrestapi.extensions

import java.time.LocalDateTime
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField
import java.util.*

//  Instead of using util classes with abstract methods like in Java,
//  it is usual in Kotlin to provide such functionalities via Kotlin
//  extensions

fun LocalDateTime.format() = this.format(englishDateFormatter)

private val daysLookup = (1..31).associate { it.toLong() to getOrdinal(it) }

private val englishDateFormatter = DateTimeFormatterBuilder()
    .appendPattern("yyyy-MM-dd")
    .appendLiteral(" ")
    .appendText(ChronoField.DAY_OF_MONTH, daysLookup)
    .appendLiteral(" ")
    .appendPattern("yyyy")
    .toFormatter(Locale.ENGLISH)

private fun getOrdinal(n: Int) = when {
    n in 11..13 -> "${n}th"
    n % 10 == 1 -> "${n}st"
    n % 10 == 2 -> "${n}nd"
    n % 10 == 3 -> "${n}rd"
    else -> "${n}th"
}

fun String.toSlug() = lowercase()
    .replace("\n", " ")
    .replace("[^a-z\\d\\s]".toRegex(), " ")
    .split(" ")
    .joinToString("-")
    .replace("-+".toRegex(), "-")

//  To declare an extension function, prefix its name with a receiver type, which refers
//  to the type being extended. The following adds a swap function to MutableList<Int>:

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

//  The 'this' keyword inside an extension function corresponds to the receiver object (the one
//  that is passed before the dot). Now, you can call such a function on any MutableList<Int>:
//
//  val list = mutableListOf(1, 2, 3)
//  list.swap(0, 2) // 'this' inside 'swap()' will hold the value of 'list'
//  This function makes sense for any MutableList<T>, and you can make it generic:
//
//  We can make it generic:
//  fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
//     val tmp = this[index1] // 'this' corresponds to the list
//     this[index1] = this[index2]
//     this[index2] = tmp
//  }
//
//  Extensions do not actually modify the classes they extend. By defining an extension,
//  you are not inserting new members into a class, only making new functions callable
//  with the dot-notation on variables of this type.


