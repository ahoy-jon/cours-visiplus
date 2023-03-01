package visiplus.pf.screencast

import zio.*
import zio.Console.*
import zio.Runtime.default

object UnsafeSystem extends zio.ZIOAppDefault {

  override def run: ZIO[Any, Any, Any] =
    for {
      _    <- printLine("Hello! What's your name?")
      name <- readLine
      _    <- printLine(s"Hello, ${name}, welcome to ZIO!")
    } yield 0
}
