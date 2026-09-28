//import Dependencies._

val scala3Version = "3.9.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "hello-kyo",
    version := "0.1.0-SNAPSHOT",
    scalacOptions ++= Seq(
      "-Wvalue-discard",
      "-Wnonunit-statement",
      "-Wconf:msg=(unused.*value|discarded.*value|pure.*statement):error",
      "-language:strictEquality"
    ),
    scalaVersion := scala3Version,
    libraryDependencies ++= Dependencies.core,
    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0" % Test
  )
