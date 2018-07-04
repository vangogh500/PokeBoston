# Poke Boston
Geolocation based pokemon game for the greater Boston area.

## Setting up local environment

### 1. CLI
Any command line interface works. If you are using windows, I use [ConEmu](https://conemu.github.io/) (it allows for multitab and other useful features).

### 2. Git
If you use any unix based OS' you'll probably have this already.

1. Just go to your CLI, enter "git". If it works you are done!
2. If not grab a copy [here](https://git-scm.com/downloads). If you are scared of Git on CLI, and you want some kind of GUI you could check out [Git Desktop](https://desktop.github.com/) or [Ungit](https://github.com/FredrikNoren/ungit). I don't use either so you'll have to try for yourself.
3. Reopen CLI and enter "git" to check if it works.

### 3. Java 8 JDK
You'll want to make sure you have the right version of Java.

1. Go to CLI
	* Enter "java -version"
	* Enter "javac -version"
	* If both print out version 1.8._ then you are all set!
2. If not you'll want to download the correct type [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) (Java 8 JDK). You'll get a couple of options, but its usually best to go with the most recent (biggest number). Once downloaded/installed try closing and reopening CLI and running the commands again. If it works, you're all set. Otherwise continue on.
3. Create "JAVA_HOME" system variable and set it the absolute path of the java jdk folder (for me this was "C:\Program Files\Java\jdk1.8.0_172"). Add "%JAVA_HOME%\bin" to your system "Path" variable.
	* On windows:
		1. Type in "Edit the system environment variables" in start menu. This will take you to the advanced tab of the system properties window.
		2. Click on "Environment Variables..." button.
		3. Create a new variable under "System variables" called "JAVA_HOME" and set it equal to the absolute path to the Java 8 JDK folder (for me this was ).
		4. Edit "Path" variable under "User variables" and add %JAVA_HOME%\bin.
		5. Save settings.

![Set up system variables on Windows](https://raw.githubusercontent.com/vangogh500/PokeBoston/master/env_setup1.png)

4. Reopen CLI and make sure commands work.

### 4. Scala & SBT

1. Install sbt (scala's interactive build tool). Go [here](https://www.scala-lang.org/download/) to download and install sbt. Scala will come included. The installer should do all the system path stuff for you.
2. Go to CLI and enter "sbt sbtVersion"

### Directory Structure
```
├── client
└── server
```

* ***client*** - Client side code
* ***server*** - Server side code
