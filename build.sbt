val scala3Version = "3.5.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "ZIO Playground",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "dev.zio" %% "zio" % "2.1.12"
  )
