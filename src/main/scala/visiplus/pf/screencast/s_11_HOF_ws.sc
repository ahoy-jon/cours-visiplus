import akka.util.Collections

import scala.annotation.tailrec
import scala.collection.immutable.{AbstractSeq, LinearSeq}

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def apply[A](xs: A*): List[A] = {
    xs match {
      case Seq() => Nil
      case Seq(a, as*) => Cons(a, List(as: _*))
    }
  }

  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(head, tail) => head + sum(tail)
  }


  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }


  def tail[A](l: List[A]): List[A] = drop(l, 1)

  def setHead[A](l: List[A], h: A): List[A] = l match {
    case Nil => List(h)
    case Cons(_, tail) => Cons(h, tail)
  }

  @tailrec
  def drop[A](l: List[A], n: Int): List[A] = l match {
    case Cons(_, tail) if n > 0 => drop(tail, n - 1)
    case _ => l
  }

  @tailrec
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Cons(head, tail) if f(head) => dropWhile(tail, f)
    case _ => l
  }

  def init[A](l: List[A]): List[A] = l match
    case Cons(_, Nil) => Nil
    case Cons(head, tail) => Cons(head, init(tail))
    case Nil => Nil


  def length[A](l: List[A]): Int =
    foldLeft(l, 0)((acc, e) => acc + 1)


  @tailrec
  def foldLeft[A, B](l: List[A], z: B)(f: (B, A) => B): B = l match
    case Nil => z
    case Cons(head, tail) => foldLeft(tail,f(z,head))(f)

  def foldRight[A, B](l: List[A], z: B)(f: (A, B) => B):B = l match
    case Nil => z
    case Cons(head, tail) => f(head, foldRight(tail, z)(f))

  //List(1, 2, 3)
  //Cons(1, Cons(2, Cons(3, Nil))))
  //f(1, f(2, f(3, z)))

  def map[A, B](l: List[A])(f: A => B): List[B] =
    foldRight[A, List[B]](l, Nil)((a, lb) => Cons(f(a), lb))
}


val l123: List[Int] = Cons(1, Cons(2, Cons(3, Nil)))

val labc = List("a", "b", "c")

List.map(labc)(c => "_" + c)

List.tail(labc)

List.drop(l123, 2 )

