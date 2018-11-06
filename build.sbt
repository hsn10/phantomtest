scalaVersion := "2.11.12"

val phantomVersion = "2.25.1"
val scalatestVersion = "3.0.4"

// Phantom dependencies
libraryDependencies ++= Seq(
  "com.outworkers"  %% "phantom-dsl" % phantomVersion,
  "com.outworkers"  %% "phantom-jdk8" % phantomVersion,
  "org.scalatest" %% "scalatest" % scalatestVersion % Test
)

javaOptions in Test ++= Seq(
  "-Xmx2G",
  "-Djava.net.preferIPv4Stack=true",
  "-Dio.netty.resourceLeakDetection"
)

fork in Test := true
