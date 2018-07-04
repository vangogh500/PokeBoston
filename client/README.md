# Poke Boston (Client)
Client side for Poke Boston app.

### Commands
To boot up the project, navigate to the server directory in the project and enter "sbt" into your CLI. From here you'll have access to the following commands:
* **fastOptJS** - This will compile your code into the server folder. This is optimized in a way the compilation is fast, but run time may not be.
* **~fastOptJS** - Same as fastOptJS but this will listen to any changes in your code and constantly recompile.
* **fullOptJS** - This will compile and optimize your code. Use this for production.
* **~fullOptJS** - Same as fullOptJS but this will listen to any changes in your code and constantly recompile.

### Directory Structure
```
├── src
│   ├── main
│   └── test
├── project
├── target
├── .gitignore
├── build.sbt
└── README.md
```

* ***src*** - All code goes here.
  * ***main*** - All main code goes here.
  * ***test*** - All test code goes here.
* ***project*** - SBT dependencies, configuration, and plugins
* ***target*** - All code and docs will be compiled to here.
* ***build.sbt*** - Defines project settings, dependencies

### Dependencies
You won't have to worry about installing any of these (sbt will do it for you), but here are some resources about the frameworks/libraries used:
* [Scalajs](https://www.google.com/search?q=scala+js&spell=1&sa=X&ved=0ahUKEwjv5Y6nw4TcAhWjo1kKHQ4TDtkQBQgmKAA&biw=1920&bih=898) - Allows for the use of scala on the frontend. Compiles scala into js
* [React](https://reactjs.org/) - Pretty popular frontend framework
* [Scalajs React](https://japgolly.github.io/scalajs-react/) - React in a way that makes sense in Scala.
* [Bootstrap](https://getbootstrap.com/) - Populat CSS library
* [ScalaCSS](https://japgolly.github.io/scalacss/book/) - CSS in a way that makes sense in Scala
