


//version du projet
version := "0.1"
//nom du projet
name := "mon-projet"

//version de scala que l'on utilise
scalaVersion := "3.2.2"

//dépendances
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % Test
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.7.0"
libraryDependencies += "dev.zio" %% "zio-direct" % "1.0.0-RC7"



lazy val root =
  (project in file("."))
    .settings(
      name := "education-scala-visiplus",
      scalacOptions ++= Seq("-Xcheck-macros"),
      libraryDependencies ++= Seq("org.scalameta" %% "munit" % "0.7.29" % Test))