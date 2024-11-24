val scala3Version = "3.5.2"
val zioVersion    = "2.1.13"

lazy val root = project
  .in(file("."))
  .settings(
    name         := "ZIO Playground",
    version      := "0.1.0",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio"               % zioVersion,
      "dev.zio" %% "zio-test"          % zioVersion % Test,
      "dev.zio" %% "zio-test-sbt"      % zioVersion % Test,
      "dev.zio" %% "zio-test-magnolia" % zioVersion % Test,
    ),
  )
