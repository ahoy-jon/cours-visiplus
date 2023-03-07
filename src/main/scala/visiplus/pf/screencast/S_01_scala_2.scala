package visiplus.pf.screencast.c05


// Main method

@main def monProgramme(): Unit = println("Bonjour !")

// Variable
val name = "John"
/*var x = 0
x = x + 1*/

// List
val ages: List[Int] = List(20, 30, 40, 50)


val ages2 = 5 :: (ages :+ 10)


// Function
def calculateSum(list: List[Int]): Int = list.sum

@main def monDeuxiemePrg(): Unit = println(calculateSum(ages))

// If as expression
val message: String = if (ages.sum > 100) "Too old" else "Just right"

var msg: String = null

object ifAsExpression:
  if (ages.sum > 100) {
    msg = "Too old"
  } else {
    msg = "Just right"
  }

// List/Option
val headOption: Option[Int] = ages.headOption

// Case class
case class Person(name: String, age: Int)

val people: List[Person] = List(Person("John", 20), Person("Jane", 30), Person("Jim", 40))

// Map

val nameAges: Seq[(String, Int)] = people.map(person => (person.name, person.age))

// ----

import scala.util.Try

// Try
def divide(a: Int, b: Int): Try[Int] = Try(a / b)

val result: Try[Int] = divide(10, 0)

val res2 = result.getOrElse(-1)


@main def printResult():Unit =
 // Print results
 println(s"Name: $name")
 println(s"Ages: $ages")
 println(s"Sum: ${calculateSum(ages)}")
 println(s"Message: $message")
 println(s"Head option: $headOption")
 println(s"People: $people")
 println(s"Name ages: $nameAges")
 println(s"Result: $result")
