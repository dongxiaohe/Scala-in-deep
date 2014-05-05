import sbt._

object Build extends Build {
   lazy val root = project.in(file(".")).aggregate(core).settings(net.virtualvoid.sbt.graph.Plugin.graphSettings: _*)
   lazy val core = project in file("core")

   def greeting() : Unit =  println("hello scala")
}
