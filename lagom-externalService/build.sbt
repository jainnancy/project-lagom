//name := "lagom-externalService"
organization in ThisBuild := "edu.knoldus"

version in ThisBuild := "0.1"

scalaVersion in ThisBuild := "2.12.5"

val macwire = "com.softwaremill.macwire" %% "macros" % "2.3.0" % "provided"

lazy val `project-lagom` = (project in file("."))
  .aggregate(`hello-lagom-api`, `hello-lagom-impl`)

lazy val `hello-lagom-api` = (project in file("hello-lagom-api"))
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslApi
    )
  )

lazy val `hello-lagom-impl` = (project in file("hello-lagom-impl"))
    .enablePlugins(LagomScala)
  .settings(
    libraryDependencies ++= Seq(
      macwire
    )
  )
  .dependsOn(`hello-lagom-api`)
