package visiplus.pf.screencast.effects

import akka.actor.{ActorRef, PoisonPill}

//Coeur fonctionnel
case class User(id: Int, name: String, email: String)

def processUsers(users: List[User]): List[String] = users.sortBy(_.name).map(user => s"${user.name} (${user.email})")

//Load
val data =
  List(
    User(1, "John Doe", "john.doe@example.com"),
    User(2, "Jane Doe", "jane.doe@example.com")
  )

//Interface impérative
@main def main(): Unit = {
  println("Liste des utilisateurs")
  processUsers(data).foreach(println)
  println("Fin de programme")
}

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object AkkaQuickstart extends App {
  val system               = ActorSystem("HelloAkka")
  val helloActor: ActorRef = system.actorOf(Props[HelloActor](), "helloActor")
  helloActor ! "Hello, Akka"
  system.scheduler.scheduleOnce(2.second, helloActor, "kill system")
}

class HelloActor extends Actor {
  def receive: Receive = {
    case "kill system" =>
      println("terminating")
      context.system.terminate()

    case message: String =>
      println(s"Received message: $message")
      context.system.scheduler.scheduleOnce(1.second, self, message + "_")
  }
}
