// And finally the plugin dependency itself
addSbtPlugin("com.outworkers" %% "phantom-sbt" % "2.15.3")

logLevel := Level.Warn

resolvers += Resolver.url("outworkers", url("https://dl.bintray.com/outworkers/oss-releases/"))(Resolver.ivyStylePatterns)

resolvers += Resolver.mavenLocal

dependencyOverrides += "org.apache.cassandra" % "cassandra-all" % "3.11.0"

dependencyOverrides += "org.cassandraunit" % "cassandra-unit" % "3.1.4.0-SNAPSHOT" excludeAll (
                          ExclusionRule("org.slf4j", "slf4j-log4j12"),
                          ExclusionRule("org.slf4j", "slf4j-jdk14"),
                          ExclusionRule("org.slf4j", "slf4j-simple")
                        )
