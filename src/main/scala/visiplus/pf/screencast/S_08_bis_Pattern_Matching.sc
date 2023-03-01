

sealed trait Expr
case class Plus(left: Expr, right: Expr) extends Expr
case class Nombre(value: Int) extends Expr
case class Variable(name: String) extends Expr
case class Mult(left: Expr, right: Expr) extends Expr




def eval(expr: Expr, vars: Map[String, Int]): Int = expr match {
  case Plus(left, right) => eval(left, vars) + eval(right, vars)
  case Nombre(value) => value
  case Variable(name) => vars(name)
  case Mult(left, right) => eval(left, vars) * eval(right, vars)
}

val expression = Plus(Mult(Nombre(2), Variable("x")), Nombre(3))
val vars = Map("x" -> 5)

// evaluates to 2 * 5 + 3 = 13
println(eval(expression, vars))