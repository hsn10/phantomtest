// And finally the plugin dependency itself
addSbtPlugin("com.outworkers" %% "phantom-sbt" % "2.14.5")

logLevel := Level.Warn

resolvers += Resolver.url("outworkers", url("https://dl.bintray.com/outworkers/oss-releases/"))(Resolver.ivyStylePatterns)
