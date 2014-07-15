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
  "org.mockito" % "mockito-all" % "1.9.5",
  "org.scala-sbt" % "io" % "0.13.2",
  "org.scala-lang.plugins" % "continuations" % "2.10.3"
)

net.virtualvoid.sbt.graph.Plugin.graphSettings

lazy val simpleWelcome = taskKey[Unit]("print out the welcome message")

fullRunTask(simpleWelcome, Compile, "build.SimplePrintTask")

//lazy val generate = taskKey[Unit]("Generate my file")
//
//generate := (runMain in Compile).toTask(" my.App").value

resolvers += Resolver.url("typesafe-ivy-repo", url("http://typesafe.artifactoryonline.com/typesafe/releases"))(Resolver.ivyStylePatterns)
//generate := (runMain in Compile).toTask(" my.App").value

autoCompilerPlugins := true

addCompilerPlugin("org.scala-lang.plugins" % "continuations" % "2.10.3")

scalacOptions += "-P:continuations:enable"