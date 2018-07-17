import scala.sys.process._

name := """server"""
organization := "com.pokeboston"
scalaVersion := "2.12.6"

version := {
  val branch = "git rev-parse --abbrev-ref HEAD".!!.trim
  val commit = "git rev-parse --short HEAD".!!.trim
  val buildTime = (new java.text.SimpleDateFormat("yyyyMMdd-HHmmss")).format(new java.util.Date())
  "%s-%s-%s".format(branch, commit, buildTime)
}

libraryDependencies ++= {
  Seq(
    guice,
    "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
  )
}

lazy val auth = (project in file("modules/auth")).enablePlugins(PlayScala).settings(
  libraryDependencies ++= {
    val play = "3.1.2"
    val sangria = "1.4.1"
    val sangria_play_json = "1.0.4"
    val aws = "1.11.362"
    Seq(
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % play % Test,
      "org.sangria-graphql" %% "sangria" % sangria,
      "org.sangria-graphql" %% "sangria-play-json" % sangria_play_json,
      "com.amazonaws" % "aws-java-sdk-cognitoidp" % aws
    )
  }
)

lazy val main = (project in file(".")).enablePlugins(PlayScala).dependsOn(auth).aggregate(auth)


// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
