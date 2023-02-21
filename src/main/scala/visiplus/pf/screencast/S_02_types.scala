package visiplus.pf.screencast


object types {
  type ??? = Nothing

  //
  // EXERCICE 1
  //
  // Liste tous les valeurs du type Boolean.
  //
  val BoolValues: Set[Boolean] = ???

  //
  // EXERCICE 2
  //
  // Liste tous les valeurs du type Unit.
  //
  val UnitValues: Set[Unit] = ???

  //
  // EXERCICE 3
  //
  // Liste tous les valeurs du type Nothing.
  //
  val NothingValues: Set[Nothing] = ???

  //
  // EXERCICE 4
  //
  // Liste tous les valeurs du type Either[Unit, Boolean].
  //
  val EitherUnitBoolValues: Set[Either[Unit, Boolean]] = ???

  //
  // EXERCICE 5
  //
  // Liste tous les valeurs du type (Boolean, Boolean).
  //
  val TupleBoolBoolValues: Set[(Boolean, Boolean)] =
  ???

  //
  // EXERCICE 6
  //
  // Liste tous les valeurs du type Either[Either[Unit, Unit], Unit].
  //
  val EitherEitherUnitUnitUnitValues: Set[Either[Either[Unit, Unit], Unit]] = ???

  //
  // EXERCICE 7
  //
  // Étant donné :
  // A = { true, false }
  // B = { "red", "green", "blue" }
  //
  // Liste tous les éléments dans A * B.
  //
  val AProductB: Set[(Boolean, String)] = ???

  //
  // EXERCICE 8
  //
  // Étant donné :
  // A = { true, false }
  // B = { "red", "green", "blue" }
  //
  // Liste tous les éléments dans A + B.
  //
  val ASumB: Set[Either[Boolean, String]] = ???

  //
  // EXERCICE 9
  //
  // Créez un type produit de Int et String, représentant l'âge et
  // le nom d'une personne.
  //
  type Person1 = ???

  final case class Person2(age: Int, name: String)

  //
  // EXERCICE 10
  //
  // Prouvez que A * 1 est équivalent à A en implémentant les deux
  // fonctions suivantes.
  //
  def to1A[A](a: (A, Unit)) : A = ???

  def from1[A](a: A): (A, Unit) = ???

  //
  // EXERCICE 11
  //
  // Prouvez que A * 0 est équivalent à 0 en implémentant les deux
  // fonctions suivantes.
  //
  def to2A: Nothing = ???

  def from2[A](n: Nothing): (A, Nothing) = ???

  //
}