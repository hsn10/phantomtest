// And finally the plugin dependency itself

logLevel := Level.Warn

resolvers += Resolver.url("outworkers", url("https://dl.bintray.com/outworkers/oss-releases/"))(Resolver.ivyStylePatterns)

resolvers += Resolver.mavenLocal

addSbtPlugin("com.outworkers" %% "phantom-sbt" % "2.17.0")

