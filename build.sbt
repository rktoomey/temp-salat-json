name := "WEC Data Processing"

version := "1.0"

scalaVersion := "2.9.1"

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Typesafe Snaps Repo" at "http://repo.typesafe.com/typesafe/snapshots/"

libraryDependencies += "se.fishtank" %% "css-selectors-scala" % "0.1.1"

// explicit dependence on casbah is not necessary, as 0.0.8 depends on 2.1.5-1
// if you want to use casbah 2.3.0, you must use 1.9-SNAPSHOT.  salat 0.0.8 doesn't support casbah 2.3.0.

libraryDependencies += "com.novus" %% "salat-core" % "0.0.8"

//libraryDependencies += "com.novus" %% "salat-core" % "1.9-SNAPSHOT"
