name := "Scala-in-deep"

version := "1.3"

scalaVersion := "2.10.4"

TaskKey[Unit]("hello") := Build.greeting

net.virtualvoid.sbt.graph.Plugin.graphSettings