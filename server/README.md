# Poke Boston (Server)
Server side for Poke Boston app.

### Setting up local environment
####AWS credentials

### Commands
To boot up the project, navigate to the server directory in the project and enter "sbt" into your CLI. From here you'll have access to the following commands:
* **compile** - This will compile code.
* **run** - This will compile and run (boot up) the server on localhost. You can type in localhost:9000 on your browser to test. You may need to compile code in client folder for anything to show up however.
* **~run** - Same as run but will listen to changes in code.
* **test** - This will run all the test files and will print a summary of results
* **~test** - Same as test but will liten to changes in code.
* **doc** - This will produce scaladoc that can then be viewed on your browser. Open "target/scala-_/api/index.html" in a browser.

### Directory Structure
```
├── .g8
├── app
│   └── views
├── conf
├── gradle
├── logs
├── project
├── public
├── target
├── test
├── .gitignore
├── build.sbt
└── README.md
```

* ***.g8*** - Used for scaffolding. Leave alone for now
* ***app*** - All main code will go here.
* ***conf*** - Application configuration. Best left alone for now.
* ***gradle*** - Gradle specs for the project. Best left alone for now.
* ***logs*** - Folder for server logs
* ***project*** - SBT dependencies, configuration, and plugins
* ***public*** - Files to be served by the server. Client js will compile into here. Inevitably we'll want to put everything here on a cdn.
* ***target*** - All code and docs will be compiled to here.
* ***test*** - All test code will go here.
* ***build.sbt*** - Defines project settings, dependencies

### Dependencies
You won't have to worry about installing any of these (sbt will do it for you), but here are some resources about the frameworks/libraries used:
* [Play](https://www.playframework.com/) - Popular backend framework for java and scala
* [GraphQL](https://graphql.org/) - Popular/better alternative to REST API
* [Sangria](https://github.com/sangria-graphql/sangria) - GraphQL for scala
