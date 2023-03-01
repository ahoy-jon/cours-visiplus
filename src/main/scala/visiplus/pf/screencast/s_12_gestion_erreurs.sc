

import scala.util.Try

def divide(num: Int, den: Int): Try[Int] = Try {
  if (den == 0) throw new ArithmeticException("Division by zero")
  else num / den
}

val result = divide(10, 2)
result match {
  case scala.util.Success(res) => println(s"Result: $res")
  case scala.util.Failure(ex) => println(s"Error: ${ex.getMessage}")
}
//Dans cet exemple, nous avons une fonction divide qui prend en entrée deux entiers num et den et retourne un Try[Int]. Si la division par zéro se produit, une exception est levée et attrapée par le Try. Ensuite, nous utilisons le pattern matching pour traiter le résultat. Si la division a réussi, nous affichons le résultat, sinon nous affichons le message d'erreur.




