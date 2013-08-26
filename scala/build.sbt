name := "binomial_pricer"

version := "1.0.0"

scalaVersion := "2.10.0"


libraryDependencies ++= Seq(
"org.scalatest" %% "scalatest" % "1.9.1" % "test")

fork in test := true

javaOptions in test += "-Xmx4G"