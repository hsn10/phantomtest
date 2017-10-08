// And finally the plugin dependency itself
addSbtPlugin("com.outworkers" %% "phantom-sbt" % "2.15.3")

logLevel := Level.Warn

resolvers += Resolver.url("outworkers", url("https://dl.bintray.com/outworkers/oss-releases/"))(Resolver.ivyStylePatterns)
