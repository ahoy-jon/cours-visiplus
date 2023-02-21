package visiplus.pf.screencast

object s_01_scala_2 {

  // Main method
  object Main extends App {
    // Variable
    val name = "John"

    // List
    val ages = List(20, 30, 40, 50)

    // Function
    def calculateSum(list: List[Int]): Int = {
      list.sum
    }

    // If as expression
    val message = if (ages.sum > 100) "Too old" else "Just right"

    // List/Option
    val headOption = ages.headOption

    // Case class
    case class Person(name: String, age: Int)

    val people = List(Person("John", 20), Person("Jane", 30), Person("Jim", 40))

    // Map
    val nameAges = people.map(person => (person.name, person.age))


    import scala.util.Try
    // Try
    def divide(a: Int, b: Int): Try[Int] = {
      Try(a / b)
    }

    val result = divide(10, 0)

    // Print results
    println(s"Name: $name")
    println(s"Ages: $ages")
    println(s"Sum: ${calculateSum(ages)}")
    println(s"Message: $message")
    println(s"Head option: $headOption")
    println(s"People: $people")
    println(s"Name ages: $nameAges")
    println(s"Result: $result")
  }
}
