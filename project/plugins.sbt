addSbtPlugin("com.outworkers" %% "phantom-sbt" % "2.24.11")

logLevel := Level.Warn

resolvers += Resolver.url("outworkers", url("https://dl.bintray.com/outworkers/oss-releases/"))(Resolver.ivyStylePatterns)
