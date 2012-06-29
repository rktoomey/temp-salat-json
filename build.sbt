name := "WEC Data Processing"

version := "1.0"

scalaVersion := "2.9.1"

resolvers += "repo.novus rels" at "http://repo.novus.com/releases/"

resolvers += "repo.novus snapshots" at "http://repo.novus.com/snapshots/"

libraryDependencies += "se.fishtank" %% "css-selectors-scala" % "0.1.1"

//libraryDependencies += "com.mongodb.casbah" %% "casbah" % "2.1.5.0"

//libraryDependencies += "com.mongodb" %% "casbah" % "2.3.0"

libraryDependencies += "com.novus" %% "salat-core" % "0.0.8"

//libraryDependencies += "com.novus" %% "salat-core" % "1.9-SNAPSHOT"