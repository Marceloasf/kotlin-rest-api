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

    // returns a Unit type, this type corresponds to the void type in Java
    private fun printSum(a: Int, b: Int) {

        // val cannot be reassigned, only var...
        // type can be explicit or inferred
        // type required when no initializer is provided, in this case, deferred assignment is an option (add the value after the val declaration)
        val sumResult: Int = a + b
        // use ${a + b} directly (String templates like js) or $variable
        println("sum of $a and $b is $sumResult")
    }
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

fun main(args: Array<String>) {
    println(args.contentToString())

    val basics = Basics()
    basics.printHelloWorld()

    val rectangle: Rectangle = Rectangle(5.0, 2.0);
    rectangle.printPerimeter()
}

