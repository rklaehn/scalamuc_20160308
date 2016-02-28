name := "scalamuc-20160308"

scalaVersion := "2.11.7"

version := "0.1-SNAPSHOT"

// spire
libraryDependencies += "org.spire-math" %% "spire" % "0.11.0"

libraryDependencies += "org.apache.commons" % "commons-math3" % "3.6"

// thyme benchmarking library
libraryDependencies += "ichi.bench" % "thyme" % "0.1.1" from "https://github.com/Ichoran/thyme/raw/master/Thyme.jar"

libraryDependencies += "org.spire-math" %% "spire-laws" % "0.11.0" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.11.6" % "test"

initialCommands in console += "import scalamuc._;"

initialCommands in console += "import spire.math._;"

initialCommands in console += "import spire.implicits._;"