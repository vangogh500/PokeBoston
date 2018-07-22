name := """client"""
organization := "com.vangogh500.pokeboston"

version := "1.0-SNAPSHOT"
scalaVersion := "2.12.6"

enablePlugins(ScalaJSPlugin)
scalaJSUseMainModuleInitializer := true

crossTarget in (Compile, fastOptJS) := file("../server/public/js")

libraryDependencies ++= {
  val scalajs_react = "1.2.3"
  val scalacss = "0.5.3"
  Seq(
    "com.github.japgolly.scalajs-react" %%% "core" % scalajs_react,
    "com.github.japgolly.scalajs-react" %%% "extra" % scalajs_react,
    "com.github.japgolly.scalacss" %%% "core" % scalacss,
    "com.github.japgolly.scalacss" %%% "ext-react" % scalacss
  )
}
