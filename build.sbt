scalaVersion := "2.11.12"

val CQLDriverVersion = "3.3.0"
val phantomVersion = "2.15.3"
val scalatestVersion = "3.0.4"

resolvers += Resolver.bintrayRepo("outworkers", "oss-releases")

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

libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.25" % "test"

PhantomSbtPlugin.projectSettings