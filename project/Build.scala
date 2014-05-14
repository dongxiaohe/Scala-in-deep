import sbt._
import Keys._

//object BuildSettings {
//  val buildSettings = Defaults.defaultSettings ++ Seq (
//    organization  := "danny.cloudTech",
//    version       := "0.0.1-SNAPSHOT",
//    scalaVersion  := "2.10.0-RC3",
//    scalacOptions += "",
//    licenses      := ("Apache2", new java.net.URL("http://www.apache.org/licenses/LICENSE-2.0.txt")) :: Nil
//  )
//}

object Build extends Build {
//  import BuildSettings._

   lazy val root = project.in(file(".")).aggregate(core).settings(net.virtualvoid.sbt.graph.Plugin.graphSettings: _*)
//   lazy val core_helper: Project = Project(
//    "core-helper",
//    file("core-helper"),
//    settings = buildSettings ++ Seq(
//      libraryDependencies <+= (scalaVersion)("org.scala-lang" % "scala-compiler" % _))
//   )

  lazy val core = project.in(file("core"))
//    .dependsOn(core_helper)

//   lazy val core_helper = project.in(file("core-helper")).settings(Seq(
//     libraryDependencies <+= (scalaVersion)("org.scala-lang" % "scala-compiler" % _))
//   ))

   def greeting() : Unit =  println("hello scala")
}
