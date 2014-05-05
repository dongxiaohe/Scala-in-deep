name := "core"

version := "1.0"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.10" % "2.1.0",
  "org.scalacheck" % "scalacheck_2.10" % "1.10.1",
  "org.scalaz" % "scalaz-core_2.10" % "7.1.0-M5",
  "com.chuusai" % "shapeless_2.10.4" % "2.0.0",
  "com.typesafe.akka" % "akka-actor_2.10" % "2.3.0",
  "org.specs2" % "specs2_2.10" % "2.3.11-scalaz-7.1.0-M6",
  "org.mockito" % "mockito-all" % "1.9.5"
)

net.virtualvoid.sbt.graph.Plugin.graphSettings