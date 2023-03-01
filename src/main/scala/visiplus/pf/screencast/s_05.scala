package visiplus.pf.screencast.s_01_scala

object Demo {

  @main
  def hello(): Unit = println("Hello World!")

  val salaire: Double = 1000.0

  println(s"salaire: $salaire")

  // le compilateur peut "deviner" le type d'une variable
  // cette variable est de type String
  val bonjour = "bonjour"

  // cette variable est initialisée uniquement si elle est utilisée
  lazy val bonjour2 = "bonjour"

  val salaires: List[Double] = List(1000.0, 2000.0, 2500.0, 3000.0)

  println(s"salaires: ${salaires.mkString(", ")}")

  def augmenter(salaires: List[Double], taux: Double): List[Double] =
    for (salaire <- salaires)
      yield salaire * (1.0 + taux)

  def masseSalaire(salaires: List[Double]): Double = salaires.sum

  def factoriel(n: Int): Int = (1 to n).product

  // remarquez le return
  def f(n: Int): Int = {
    val c = n + 2

    n * (1 + c) // ceci calcule le résultat de la fonction
  }

  // Contrairement à la plupart des langages de programmation, la structure if n'est pas une instruction, mais une expression.
  //  Il est donc possible d'inclure la structure if dans d'autres expressions.
  val activated = true

  val affichageActivation =
    if (activated) "activé"
    else "désactivé"

  val cmd: Unit = println(s"la fonction est $affichageActivation")

  // val valeurs1: List[Int] = List(1)
  // val valeurs2: List[Int] = Nil // ou List()

  // val valeurs1: Option[Int] = Option(1) // ou Some(1)
  // val valeurs2: Option[Int] = None

  import scala.util._

  val valeurs1: Try[Int] = Success(1)
  val valeurs2: Try[Int] = Failure(new NoSuchElementException)

  val résultats =
    for {
      v1 <- valeurs1
      v2 <- valeurs2
    } yield v1 + v2

  case class Utilisateur(id: String, nom: String, âge: Int)

  println(s"john: ${Utilisateur(id = "123", nom = "John", âge = 24)}")

  val baseDeDonnees: Map[String, Utilisateur] =
    Map(
      "123" -> Utilisateur(id = "123", nom = "John", âge = 24),
      "456" -> Utilisateur(id = "456", nom = "Mary", âge = 25)
    )

  val cmd3 = {
    println(s"base de données:")
    baseDeDonnees.foreach(println)
    baseDeDonnees.foreach { case (_, utilisateur) => println(utilisateur) }

  }
}
