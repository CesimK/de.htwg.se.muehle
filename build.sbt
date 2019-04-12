name := "de.htwg.se.muehle"

version := "0.1"

scalaVersion := "2.12.8"

sbtPlugin := true
coverageExcludedPackages :=  ".*/Muehle.scala"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
