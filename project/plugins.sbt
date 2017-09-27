// And finally the plugin dependency itself
addSbtPlugin("com.outworkers" %% "phantom-sbt" % "2.13.4")

logLevel := Level.Warn

resolvers += Resolver.url("outworkers", url("https://dl.bintray.com/outworkers/oss-releases/"))(Resolver.ivyStylePatterns)

val CQLDriverVersion = "3.3.0"

// latest Cassandra driver
libraryDependencies += "com.datastax.cassandra" % "cassandra-driver-core" % CQLDriverVersion

