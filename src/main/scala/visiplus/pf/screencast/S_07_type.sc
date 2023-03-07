
type ??? = Nothing

//
// EXERCICE 1
//
// Liste tous les valeurs du type Boolean.
//
val BoolValues: Set[Boolean] = Set(true, false)

BoolValues.size

//
// EXERCICE 2
//
// Liste tous les valeurs du type Unit.
//
val UnitValues: Set[Unit] = Set((), {})
UnitValues.size
//
// EXERCICE 3
//
// Liste tous les valeurs du type Nothing.
//
val NothingValues: Set[Nothing] = Set()

//
// EXERCICE 4
//
// Liste tous les valeurs du type Either[Unit, Boolean].
//
val e1: Either[Unit, Boolean] = Left(())
val e2: Either[Unit, Boolean] = Right(true)
val e3: Either[Unit, Boolean] = Right(false)

val EitherUnitBoolValues: Set[Either[Unit, Boolean]] = Set(e1, e2, e3)



case class MonProduit(a:Boolean, b:Boolean)
//
// EXERCICE 5
//
// Liste tous les valeurs du type (Boolean, Boolean).
//
val TupleBoolBoolValues: Set[(Boolean, Boolean)] =
Set(
  (true, true), (true, false), (false, true), (false, false)
)

//
// EXERCICE 6
//
// Liste tous les valeurs du type Either[Either[Unit, Unit], Unit].

//
type EEE = (Unit Either Unit) Either Unit

val EitherEitherUnitUnitUnitValues: Set[Either[Either[Unit, Unit], Unit]] = Set(
  Right(()),
  Left(Left(())),
  Left(Right(()))
)

//
// EXERCICE 7
//
// Étant donné :
// A = { true, false }
// B = { "red", "green", "blue" }
//
// Liste tous les éléments dans A * B.
//
val AProductB: Set[(Boolean, String)] = Set(
  (true, "red"), (true, "green"), (true, "blue"),
  (false, "red"), (false, "green"), (false, "blue")
)

//
// EXERCICE 8
//
// Étant donné :
// A = { true, false }
// B = { "red", "green", "blue" }
//
// Liste tous les éléments dans A + B.
//
val ASumB: Set[Either[Boolean, String]] =
Set(Left(true), Left(false),
  Right("red"), Right("green"),
  Right("blue"))

//Card[A Either B] = Card[A] + Card[B]
//Card[(A,B)] = Card[A] * Card[B]


//
// EXERCICE 9
//
// Créez un type produit de Int et String, représentant l'âge et
// le nom d'une personne.
//
type Person1 = (Int, String)

final case class Person2(age: Int, name: String)

val person1: Person1 = (13, "Toto")
val person2: Person2 = Person2(14, "Tata")

person1._1
person2.age

///-----
//
// EXERCICE 10
//
// Prouvez que A * 1 est équivalent à A en implémentant les deux
// fonctions suivantes.
//
def to1A[A](a: (A, Unit)): A = a._1
def from1[A](a: A): (A, Unit) = (a, ())


//On peut prouver d'autres équivalences :
// A * 0 = 0

type Product[X, Y] = (X, Y)
def to0tA[A](at: A Product Nothing):Nothing = at._2
def from0t[A](n: Nothing): A Product Nothing = n

// A + 0 = A
def to0pA[A](at: A Either Nothing): A = {
  at match
    case Left(l) => l
    case Right(r) => r

  at.merge
}

def from0pA[A](a: A): A Either Nothing = Left(a)


//Map[A,B]
// Card[A => B] = Card[B] ^ Card[A]
