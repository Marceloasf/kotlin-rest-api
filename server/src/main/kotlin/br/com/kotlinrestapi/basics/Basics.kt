package br.com.kotlinrestapi.basics

class Basics {

    var sum1 = 21
    val sum2 = 21

    fun printHelloWorld() {

        val world = " World"
        // Variable is never modified so it can be declared using 'val'
        // type can be explicit or inferred
        var hello = "Hello"

        print(hello)
        println(world)
        this.printSum(sum1, sum2)
    }

//    Conditional expressions
//    fun maxOf(a: Int, b: Int): Int {
//        if (a > b) {
//            return a
//        } else {
//            return b
//        }
//    }

//    fun maxOf(a: Int, b: Int) = if (a > b) a else b

    // returns a Unit type, this type corresponds to the void type in Java
    private fun printSum(a: Int, b: Int) {

        // val cannot be reassigned, only var...
        // type can be explicit or inferred
        // type required when no initializer is provided, in this case, deferred assignment is an option (add the value after the val declaration)
        val sumResult: Int = a + b
        // use ${a + b} directly (String templates like js) or $variable
        println("sum of $a and $b is $sumResult")
    }

//    Loops
//
//    for loop
//    val items = listOf("apple", "banana", "kiwifruit")
//    for (item in items) {
//        println(item)
//    }
//
//    val items = listOf("apple", "banana", "kiwifruit")
//    for (index in items.indices) {
//        println("item at $index is ${items[index]}")
//    }
//
//    while loop
//    val items = listOf("apple", "banana", "kiwifruit")
//    var index = 0
//    while (index < items.size) {
//        println("item at $index is ${items[index]}")
//        index++
//    }
//
//    when expression
//    fun describe(obj: Any): String =
//        when (obj) {
//            1          -> "One"
//            "Hello"    -> "Greeting"
//            is Long    -> "Long"
//            !is String -> "Not a string"
//            else       -> "Unknown"
//        }
//
//    Ranges
//    val x = 10
//    val y = 9
//    if (x in 1..y+1) {
//        println("fits in range")
//    }
//
//    Check if a number is out of range.
//    val list = listOf("a", "b", "c")
//
//    if (-1 !in 0..list.lastIndex) {
//        println("-1 is out of range")
//    }
//    if (list.size !in list.indices) {
//        println("list size is out of valid list indices range, too")
//    }
//
//    Iterate over a range.
//    for (x in 1..5) {
//        print(x)
//    }
//
//    Or over a progression.
//    for (x in 1..10 step 2) {
//        print(x)
//    }
//    println()
//    for (x in 9 downTo 0 step 3) {
//        print(x)
//    }
//
//    Nullable values and null checks
//    A reference must be explicitly marked as nullable when null value is possible. Nullable type names have ? at the end.
//
//    fun parseInt(str: String): Int? {
//        // Return null if str does not hold an integer
//    }
//
//    fun printProduct(arg1: String, arg2: String) {
//    val x = parseInt(arg1)
//    val y = parseInt(arg2)
//
//    // Using `x * y` yields error because they may hold nulls.
//    if (x != null && y != null) {
//        // x and y are automatically cast to non-nullable after null check
//        println(x * y)
//    }
//    else {
//        println("'$arg1' or '$arg2' is not a number")
//    }
//}
//
//    Type checks and automatic casts
//
//    The is operator checks if an expression is an instance of a type.
//    If an immutable local variable or property is checked for a specific type, there's no need to cast it explicitly.
//    fun getStringLength(obj: Any): Int? {
//        if (obj is String) {
//            // `obj` is automatically cast to `String` in this branch
//            return obj.length
//        }
//
//        // `obj` is still of type `Any` outside of the type-checked branch
//        return null
//    }
//
//    fun getStringLength(obj: Any): Int? {
//        if (obj !is String) return null
//
//        // `obj` is automatically cast to `String` in this branch
//        return obj.length
//    }
//
//    fun getStringLength(obj: Any): Int? {
//        // `obj` is automatically cast to `String` on the right-hand side of `&&`
//        if (obj is String && obj.length > 0) {
//            return obj.length
//        }
//
//        return null
//    }
//
}

// to make a class inheritable, mark it as open
open class Shape

/* properties var/val of a class can be omitted;
   inheritance between classes is declared by a colon (: Shape())
 */
class Rectangle(height: Double, length: Double): Shape() {
    private val perimeter = (height + length) * 2

    fun printPerimeter() = println("The perimeter is ${this.perimeter}")
}

class Collections {
//    Iterate over a collection.
//    for (item in items) {
//        println(item)
//    }
//
//    when {
//        "orange" in items -> println("juicy")
//        "apple" in items -> println("apple is fine too")
//    }
//
//    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
//        fruits
//        .filter { it.startsWith("a") }
//        .sortedBy { it }
//        .map { it.uppercase() }
//        .forEach { println(it) }
}

fun main(args: Array<String>) {
    println(args.contentToString())

    val basics = Basics()
    basics.printHelloWorld()

    val rectangle: Rectangle = Rectangle(5.0, 2.0);
    rectangle.printPerimeter()
}

