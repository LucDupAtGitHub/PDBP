name := "pdbp"
version := "0.1.0-SNAPSHOT"
organization := "com.imaginej"
scalaVersion := "0.6.0-RC1"

scalacOptions += "-deprecation"
logBuffered in Test := false

val akkaVersion = "2.5.99-TYPED-M1"

resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"

libraryDependencies ++= Seq(
  "com.chuusai" %% "shapeless" % "2.3.2",
  "com.typesafe.akka" %% "akka-typed" % akkaVersion,
  "com.typesafe.akka" %% "akka-typed-testkit" % akkaVersion % "test",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.4" % "test",
  "ch.qos.logback" % "logback-classic" % "1.0.9"
).map(lib => lib.withDottyCompat())
