package visiplus.pf

@main
def bonjour(): Unit = println("Bonjour !")

//record
case class Person(id: Int, name: String, age: Int)

//variable (asignable)
val people =
  Map(
    1 -> Person(1, "John", 25),
    2 -> Person(2, "Jane", 30)
  )

//var people = ???

//methode
def olderPerson(id1: Int, id2: Int): Option[Person] =
  // for-comprehension
  for {
    p1 <- people.get(id1)
    p2 <- people.get(id2)
  } yield if (p1.age > p2.age) p1 else p2

val oldestPerson = olderPerson(1, 2)

@main
def checkOldest(): Unit =
  // pattern matching
  oldestPerson match {
    case Some(p) => println(s"The older person is ${p.name}")
    case None    => println("Both people were not found")
  }

import scala.math.BigDecimal.RoundingMode

def calculateVAT(amount: BigDecimal): BigDecimal = (amount * BigDecimal(0.2)).setScale(2, RoundingMode.HALF_UP)

val amount = BigDecimal(100)
val vat    = calculateVAT(amount)

def calcVAT(): Unit = println(s"Montant : $amount, TVA : $vat")

object TypesExercises {
  // Le type `Nothing` correspond à un sous-type de tous les autres types et n'inclut aucune valeur
  type Rien = Nothing

  // Exercice 1 : Listez toutes les valeurs du type `Boolean`
  val valeursBool: Set[Boolean] = Set(true, false)

  // Exercice 2 : Listez toutes les valeurs du type `Unit`
  val valeursUnit: Set[Unit] = Set(())

  // Exercice 3 : Listez toutes les valeurs du type `Nothing`
  val valeursNothing: Set[Nothing] = Set()

  // Exercice 4 : Listez toutes les valeurs du type `Either[Unit, Boolean]`
  val valeursEitherUnitBool: Set[Either[Unit, Boolean]] = Set(Left(()), Right(true), Right(false))

  // Exercice 5 : Listez toutes les valeurs du type `(Boolean, Boolean)`
  val valeursTupleBoolBool: Set[(Boolean, Boolean)] =
    for {
      b1 <- valeursBool
      b2 <- valeursBool
    } yield (b1, b2)

  // Exercice 6 : Listez toutes les valeurs du type `Either[Either[Unit, Unit], Unit]`
  val valeursEitherEitherUnitUnitUnit: Set[Either[Either[Unit, Unit], Unit]] =
    Set(
      Left(Left(())),
      Left(Right(())),
      Right(())
    )

  // Exercice 7 : Donnez les éléments dans `A * B` avec `A = { true, false }` et `B = { "red", "green", "blue" }`
  val produitAB: Set[(Boolean, String)] =
    for {
      b <- valeursBool
      s <- Set("red", "green", "blue")
    } yield (b, s)

  // Exercice 8 : Donnez les éléments dans `A + B` avec `A = { true, false }` et `B = { "red", "green", "blue" }`
  val sommeAB: Set[Either[Boolean, String]] = valeursBool.map(Left(_)) ++ Set("red", "green", "blue").map(Right(_))

  // Exercice 9 : Cr
}
