package visiplus.pf.screencast.s03

object s03 {

  import scala.annotation.tailrec
  import scala.util.Random

  import java.time.LocalDate

  /**
   * =Les fonctions en tant que valeur=
   * Comme de nombreux autres langages de programmation fonctionnelle,
   * vous pouvez définir les fonctions en tant que valeur.
   *
   * Les principaux avantages des fonctions en tant que valeur sont :
   *   - La possibilité de donner une fonction en paramètre
   *   - La possibilité de retourner une fonction
   *   - La possibilité de composer des fonctions
   *
   * Nous verrons ces trois points dans ce laboratoire.
   */
  @main
  def _02_fonction_en_tant_que_valeur(): Unit =
    section("Les bases des fonctions en tant que valeur") {

      exercice("Déclarer une fonction en tant que valeur") {
        val enMajusculeEnTantQueValeur: String => String = chaine => chaine.toUpperCase
        //                    ^^^^^^^^^^^^^^^^   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        //                    |                  Corps de la fonction
        //                    Paramètre -> Type de retour

        // Trouvez l'équivalent de cette fonction en tant que valeur en utilisant def :
        def enMajusculeEnTantQueFonction(chaine: String): String = chaine.toUpperCase

        verifier(enMajusculeEnTantQueFonction(chaine = "scala") == enMajusculeEnTantQueValeur(v1 = "scala"))
      }

      exercice("Passer une fonction en tant que paramètre") {
        // Une fonction qui applique la fonction `f` donnée à tous les éléments d'une liste.
        def appliquerFonctionSurTousLesElements(liste: List[Int], f: Int => Int): List[Int] = liste.map(f)

        val liste = List(1, 2, 3)

        // Écrivez la fonction `pow` en utilisant la fonction en tant que valeur.
        val pow: Int => Int = x => x ^ x

        verifier(appliquerFonctionSurTousLesElements(liste, pow) == List(1, 4, 9))
      }

      /**
       * Une fonction peut retourner une autre fonction. Par exemple,
       * essayons de créer une fonction qui retournera un traducteur en
       * fonction de la langue de l'utilisateur.
       */
      exercice("Retourner une fonction") {
        // Une fonction qui applique

        enum Langue {
          case FR, EN
        }

        def traducteur(langue: Langue): String => String = {
          def traduireFR(cle: String): String =
            cle match {
              case "bonjour" => "Bonjour le monde"
              case _         => "Inconnu"
            }

          def traduireEN(cle: String): String =
            cle match {
              case "hello" => "Hello world"
              case _       => "Unknown"
            }

          langue match {
            case Langue.FR => traduireFR
            case Langue.EN => traduireEN
          }
        }

        val traducteurFR = traducteur(Langue.FR)
        verifier(traducteurFR("bonjour") == "Bonjour le monde")

        val traducteurEN = traducteur(Langue.EN)
        verifier(traducteurEN("hello") == "Hello world")

      }
    }

    def section(name: String)(body: => Unit): Unit = {}

    def exercice(name: String)(body: => Unit): Unit = {}

    def verifier(pred: => Boolean): Unit = {}
}
