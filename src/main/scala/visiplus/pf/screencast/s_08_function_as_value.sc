val enMajusculeEnTantQueValeur: String => String = chaine => chaine.toUpperCase
//                              ^^^^^^^^^^^^^^^^   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//                              |                  Corps de la fonction
//                              Paramètre -> Type de retour

// L'équivalent de cette fonction en tant que valeur en utilisant def :
def enMajusculeEnTantQueFonction(chaine: String): String = chaine.toUpperCase



val listF: List[String => String] =
  List(enMajusculeEnTantQueValeur, enMajusculeEnTantQueFonction)

val vals: List[String] = listF.map(f => f("test fonction N"))


val f2: Function1[String, String] = x => x.toUpperCase


f2("test fonction N")






// Une fonction qui applique la fonction `f` donnée à tous les éléments d'une liste.
def appliquerFonctionSurTousLesElements(liste: List[Int], f: Int => Int): List[Int] = liste.map(f)

val liste = List(1, 2, 3)

val pow: Int => Int = x => x ^ x


enum Langue {
  case FR, EN
}

def traducteur(langue: Langue): String => String = {
  def traduireFR(cle: String): String =
    cle match {
      case "bonjour" => "Bonjour le monde"
      case _ => "Inconnu"
    }

  def traduireEN(cle: String): String =
    cle match {
      case "hello" => "Hello world"
      case _ => "Unknown"
    }

  langue match {
    case Langue.FR => traduireFR
    case Langue.EN => traduireEN
  }
}

val traducteurFR = traducteur(Langue.FR)
traducteurFR("bonjour") == "Bonjour le monde"

val traducteurEN = traducteur(Langue.EN)
traducteurEN("hello") == "Hello world"