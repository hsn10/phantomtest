scalaVersion := "2.11.11"

val phantomVersion = "2.17.0"
val scalatestVersion = "3.0.4"

// Phantom dependencies
libraryDependencies ++= Seq(
  "com.outworkers"  %% "phantom-dsl"                   % phantomVersion,
  "com.outworkers"  %% "phantom-jdk8"                  % phantomVersion
)

libraryDependencies += "org.scalatest" %% "scalatest" % scalatestVersion % "test"

libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.25" % "test"

PhantomSbtPlugin.projectSettings