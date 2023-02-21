


package visiplus.pf


@main
def hello() = println("hello")

object Main {

  def main(args: Array[String]): Unit = {
    println("toto")
  }
}

object Slides {
  case class ProductLine(quantity: Int, costPerItem: Double)

  case class Bill(productLines: Seq[ProductLine]) {
    def total: Double = productLines
      .map(line => line.quantity * line.costPerItem)
      .sum
  }
}


def add0(a: Int, b: Int): Int = a + b
val res0 = add0(a = 1, b = 2)

val add1 = (a: Int, b: Int) => a + b
val res1 = add1(v1 = 1, v2 = 2)

class Add2 extends Function2[Int, Int, Int] {
  override def apply(v1: Int, v2: Int): Int = v1 + v2
}

val res2 = (new Add2()).apply(v1 = 1, v2 = 2)


def times2(x: Int): Int = 2 * x
def square(x: Int): Int = x * x

val numbers = List(1, 2, 3, 4)
val squares = numbers.map(square) // List(1,4,9,16)


val fs: List[Int => Int] = List(times2, squares)
val applyOn3 = fs.map(_ (3)) // List(6,9)


case class Product(name: String, price: Double, quantity: Int) {
  def total: Double = price * quantity
}

val product = Product("test", 10, 1)

val product_ = {
  product.name // "test"
  product.price // 10.0d
  product.quantity // 1
}


def calculateTotal(products: List[Product]): Double = {
  products.map(_.total).sum
}


var x = 0

def ajouterUn(n: Int): Int = {
  x += 1;
  n + 1
}

//ajouterUn(42) // 43 (et x = 1)
//ajouterUn(24) // 25 (et x = 2)


val text = ""
val hello2 =
  text.split("\n").toList
    .filter(_.trim.nonEmpty)
    .map(_.toUpperCase).mkString("\n")

val toto = {
  val lines = text.split("\n").toList
  val nonEmptyLines = lines.filter(_.trim.nonEmpty)
  val upperCaseLines = nonEmptyLines.map(_.toUpperCase)
  upperCaseLines.mkString("\n")


  def sum(l: List[Int]): Int = l.sum

  def count[A](l: List[A]): Int = l.size

  def divide(tuple: (Int, Int)): Double = tuple._1.toDouble / tuple._2.toDouble


  def duplicate[A](a: A): (A, A) = (a, a)

  def bimap[A, B, C](f: A => B)(g: A => C)(tuple: (A, A)): (B, C) = (f(tuple._1), g(tuple._2))


  // point-free style (or tacit programming)
  val average_1: List[Int] => Double =
    divide compose bimap(sum)(count[Int]) compose duplicate[List[Int]]

  // usual style
  def average_2(l: List[Int]): Double = l.sum.toDouble / l.size.toDouble

}


def invertIfRed(in: Boolean, b: Couleur): Boolean = ???


// Déclaration d'une énumération associant une valeur à chaque élément
enum Couleur(val valeur: Int):
  case ROUGE extends Couleur(1)
  case VERT extends Couleur(2)
  case BLEU extends Couleur(3)
  Couleur.ROUGE // ROUGE
  Couleur.ROUGE.valeur // 1


sealed abstract class OrderStatus_S2(val id: String)

object OrderStatus_S2 {
  case object Draft extends OrderStatus_S2("DRAFT")

  case object Submitted extends OrderStatus_S2("SUBMITTED")

  case object Delivered extends OrderStatus_S2("DELIVERED")
}

trait A //interface

case class B(value: String) extends A

val a: A = B("je suis un B") // a := B(je suis un B)


val produit = (1, "abc", true)
val res = {
  produit._1 // 1
  produit._2 // "abc"
  produit._3 // true
}


def parseInt(input: String): Int = {
  try {
    input.toInt
  }
  catch {
    case _: NumberFormatException => 0
  }
}

def length(input: String): Int = {
  input.length
}


import java.io.File
import java.nio.file.{Files, StandardOpenOption}

def touch(filename: String): Long = {
  val file = new File(filename)
  if (!file.exists) file.createNewFile()
  Files.write(file.toPath, Array[Byte](), StandardOpenOption.APPEND)
  file.lastModified
}

val plop_ = {
  var counter = 0

  def incCounter(): Int = {
    counter += 1
    counter
  }

  println(incCounter()) // Affiche 1
  println(incCounter()) // Affiche 2
  println(incCounter()) // Affiche 3
}


case class ProductLine(costPerItem: Double, quantity: Int = 1)

case class Bill(productLines: Seq[ProductLine]) {
  def total: Double =
    productLines.map(p => p.costPerItem * p.quantity).sum
}


case class State(n: Int,
                 minValue: Int,
                 maxValue: Int):

  def inc: State =
    if n == maxValue then
      this
    else
      this.copy(n = n + 1)


trait Message:
  def get: String


sealed trait Animal:
  def name: String

  final def fullName: String = s"$name ($tpe)"

  private def tpe: String = this.getClass.getSimpleName

object Animal:
  case class Dog(name: String) extends Animal

  case class Cat(name: String) extends Animal


@main def animalMain(): Unit =
  println(Animal.Dog("felix").fullName) //felix (Dog)


def f1(i: Int, j: Int) = i + j
val f2 = (x: Int) => f1(x, x)

trait F1[A, B]

type F2[A] = F1[A, A]


@main def testStringReplace:Unit = println("abc  ()  def".replaceAll("\\W+","-"))

def factorial(n: Long): Long =
  var result = 1L
  for i <- 1L to n
    do result *= i
  result

@main def testFactorial:Unit = println(factorial(10))


enum MyList[+A]:
  // représente la fin de la liste chainée
  case Nil
  // ce constructeur ajoute un élément au début de la liste
  case Cons(valeur: A, queue: MyList[A])

// représente la liste [1, 2, 3]
val l: MyList[Int] = MyList.Cons(1, MyList.Cons(2, MyList.Cons(3, MyList.Nil)))


object CompteBancaires  {

  class CompteBancaireMutable(soldeInitial: Double):
    // variable d'état privée qui stocke le solde actuel
    private var soldeCourant = soldeInitial
    def retirer(montant: Double): Unit = soldeCourant -= montant
    def deposer(montant: Double): Unit = soldeCourant += montant
    def solde: Double = soldeCourant


  // création d'un compte avec un solde initial de 100.0
  val compte1 = new CompteBancaireMutable(100.0)
  // dépôt de 10.0
  compte1.deposer(10.0)

  // partage de la référence entre compte1 et compte2
  val compte2: CompteBancaireMutable = compte1
  // retrait de 20.0
  compte2.retirer(20.0)
  // retrait de 30.0
  compte2.retirer(30.0)

  // affichage du solde de compte1 et compte2
  println(compte1.solde) // 60.0
  println(compte2.solde) // 60.0


  object Take2 {
    case class CompteBancaireImmutable(solde: Double):
      def retirer(montant: Double): CompteBancaireImmutable =
        copy(solde = solde - montant)
      def deposer(montant: Double): CompteBancaireImmutable =
        copy(solde = solde + montant)

    val compte1 = CompteBancaireImmutable(100.0)
    val compte2 = compte1.deposer(10.0)

    val compte3 = compte2.retirer(20.0).retirer(30.0)

    println(compte1.solde) // 100.0
    println(compte2.solde) // 110.0
    println(compte3.solde) //  60.0
    println(compte3.solde - compte1.solde) //40.0
  }
}

object TryEtTry {

  def divide(numerator: Int, denominator: Int): Int =
    try
      numerator / denominator
    catch
      case e: ArithmeticException => 0


  object avecTry {

    import scala.util.Try
    def divide(numerator: Int, denominator: Int): Try[Int] =
      Try(numerator / denominator)


  }

}

object MathUtils {
  def sqrt(x: Double): Double = ???
  def sin(x: Double): Double = ???
}


@main def testMathUtils:Unit =  {
  val result = MathUtils.sqrt(16.0)
  println(result) // 4.0
}