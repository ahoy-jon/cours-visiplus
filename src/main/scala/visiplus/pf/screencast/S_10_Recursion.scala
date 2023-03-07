package visiplus.pf.screencast.s_10

import scala.annotation.tailrec
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.util.{Failure, Success, Try}

import java.time.Duration
import java.util.concurrent.TimeUnit



object Factorial {
  def factorial(n: Int): Int = {
    if(n == 0) 1
    else n * factorial(n - 1)
  }

  def factorial2(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else go(n-1, n*acc)

    go(n, 1)
  }
}


@main
def makeFactorial():Unit =
  //println(Factorial.factorial(14000))
  println(Factorial.factorial2(50000))

