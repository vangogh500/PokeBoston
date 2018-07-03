name := """server"""
organization := "com.vangogh500.pokeboston"

version := "1.0-SNAPSHOT"
scalaVersion := "2.12.6"

enablePlugins(PlayScala)

libraryDependencies ++= {
  Seq(
    guice,
    "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
  )
}

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
