scalaVersion := "2.11.11"

val CQLDriverVersion = "3.3.0"
val phantomVersion = "2.14.5"
val scalatestVersion = "3.0.4"

// Cassandra driver
libraryDependencies ++= Seq(
   "com.datastax.cassandra" % "cassandra-driver-core" % CQLDriverVersion
)

// Phantom dependencies
libraryDependencies ++= Seq(
  "com.outworkers"  %% "phantom-connectors"            % phantomVersion,
  "com.outworkers"  %% "phantom-dsl"                   % phantomVersion,
  "com.outworkers"  %% "phantom-jdk8"                  % phantomVersion
)

libraryDependencies += "org.scalatest" %% "scalatest" % scalatestVersion % "test"