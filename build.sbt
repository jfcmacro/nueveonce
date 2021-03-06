lazy val commonSettings = Seq(
  organization := "co.edu.eafit",
  version := "0.1.0",
  scalaVersion := "2.11.7"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "BerryBerry"
  )

 libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.2"
