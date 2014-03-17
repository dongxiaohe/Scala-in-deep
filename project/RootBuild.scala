import sbt._

object RootBuild extends Build {
   lazy val root = project.in(file(".")).aggregate(core)
   lazy val core = project in file("core")

//   lazy val core = Project(id = "core",
//     base = file("core")).configs( ScalaTest ).settings( inConfig(ScalaTest)(Defaults.testTasks) : _*).in( file("core"))
//   lazy val ScalaTest = config("core/src/test") extend(Test)

 }
