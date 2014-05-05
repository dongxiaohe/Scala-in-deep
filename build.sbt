name := "Scala-in-deep"

version := "1.3"

TaskKey[Unit]("hello") := Build.greeting

net.virtualvoid.sbt.graph.Plugin.graphSettings