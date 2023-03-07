

sealed trait Expr

object Expr {
  // type Expr = Plus (Expr * Expr) | Nombre (Int) | Variable (String) | Mult (Expr * Expr)
  case class Plus(left: Expr, right: Expr) extends Expr

  case class Nombre(value: Int) extends Expr

  case class Variable(name: String) extends Expr

  case class Mult(left: Expr, right: Expr) extends Expr
}


import Expr._

val x = Variable("x")
val n1 = Nombre(1)

//x + 1 => +(x, 1), => x 1 +
val expr1: Expr = Plus(x, n1)

// x * 1 + x * b => +( *(x,1) ,  *(x, b)) => 1 x * x b * +
val expr2: Expr = Plus(Mult(x, n1), Mult(x, Variable("b")))


def eval(expr: Expr, vars: Map[String, Int]): Int = expr match {
  case Plus(left, right) => eval(left, vars) + eval(right, vars)
  case Nombre(value) => value
  case Variable(name) => vars(name)
  case Mult(left, right) => eval(left, vars) * eval(right, vars)
}


def optim(expr: Expr): Expr = expr match
  case Mult(Nombre(0), _) => Nombre(0)
  case Mult(_, Nombre(0)) => Nombre(0) //(a * x + a * y) == (a * (x + y))
  case Plus(Mult(a, b), Mult(c, d)) if a == c => Mult(a, Plus(b, d))
  // ...
  case Plus(left, right) => Plus(optim(left), optim(right))
  case Mult(left, right) => Mult(optim(left), optim(right))
  case _ => expr


optim(Plus(Nombre(1), Mult(Nombre(0), x)))

expr2
optim(expr2)


eval(expr2, Map("x" -> 2, "b" -> 10))


val expression = Plus(Mult(Nombre(2), x), Nombre(3))
val vars = Map("x" -> 5)

// evaluates to 2 * 5 + 3 = 13
println(eval(expression, vars))

def fold[C](variable: String => C, number: Int => C)
           (plus: (C, C) => C, mult: (C, C) => C): Expr => C = {
  val self: Expr => C = fold(variable, number)(plus, mult)
  {
    case Nombre(value) => number(value)
    case Variable(name) => variable(name)
    case Plus(left, right) => plus(self(left), self(right))
    case Mult(left, right) => mult(self(left), self(right))
  }
}

fold(_ => 0, i => i)(_ + _, _ * _)

trait ExprVisitor[T] {
  def visitNombre(number: Nombre): T = zero

  def visitVariable(variable: Variable): T = zero

  def visitePlus(plus: Plus): T =
    combineChilds(visiteExpr(plus.left), visiteExpr(plus.right))

  def visiteMult(mult: Mult): T =
    combineChilds(visiteExpr(mult.left), visiteExpr(mult.right))


  def visiteExpr(expr: Expr): T = expr match
    case p: Plus => visitePlus(p)
    case n: Nombre => visitNombre(n)
    case v: Variable => visitVariable(v)
    case m: Mult => visiteMult(m)

  def combineChilds(t1: T, ts: T*): T = (t1 :: ts.toList).reduce(combine)

  def combine(t1: T, t2: T): T

  def zero: T
}


val listVariables = new ExprVisitor[List[String]]:
  override def combine(t1: List[String], t2: List[String]): List[String] = t1 ++ t2
  override def zero: List[String] = Nil
  override def visitVariable(variable: Variable) = List(variable.name)


val listVariableFold = fold(List.apply, _ => Nil)(_ ++ _, _ ++ _)
