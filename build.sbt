name := "Akka-Http-Scala-Cinnamon-DataDog-Seed"

version := "1.0"

scalaVersion := "2.12.2"

lazy val akkaHttpVersion = "10.0.9"
lazy val akkaVersion = "2.5.3"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test,
  Cinnamon.library.cinnamonAkka, //Akka based application monitoring via Cinnamon
  Cinnamon.library.cinnamonDataDog, //For using DataDog as backend agent
  "org.scalatest" %% "scalatest" % "3.0.1" % Test
)

lazy val app = project in file(".") enablePlugins Cinnamon
cinnamon in run := true
cinnamon in test := true
cinnamonLogLevel := "INFO"