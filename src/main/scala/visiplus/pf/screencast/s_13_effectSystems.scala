package visiplus.pf.screencast

import zio.*
import zio.Console.*
import zio.Runtime.default

import java.io.IOException

object SomeSystem extends zio.ZIOAppDefault {

  override def run: ZIO[Any, Any, Any] =
    for {
      _ <- printLine("Hello! What's your name?")
      name <- readLine
      _ <- printLine(s"Hello, ${name}, welcome to ZIO!")
    } yield 0
}

trait A {
  def w: String
}

import zio.direct._

object DirectStyle extends zio.ZIOAppDefault:
  val prg = defer {
    printLine("Hello! What's your name?").run
    val name = readLine.run
    val w = ZIO.service[A].run.w
    printLine(s"yo $name $w").run
  }

  override def run: ZIO[Any, Any, Any] = prg.provideEnvironment(ZEnvironment(new A {
    override def w: String = "!!"
  }))
