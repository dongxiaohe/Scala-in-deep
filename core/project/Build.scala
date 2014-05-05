import sbt._

object Build extends Build {
   lazy val core = project in file("core").settings(net.virtualvoid.sbt.graph.Plugin.graphSettings: _*)
}
