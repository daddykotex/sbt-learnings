import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.1",
    	publishTo 	 := Some(Resolvers.DummyResolver)
    )),
    name      		 := "my-multi-project-root",
    publish 			 := {} // avoid publishing the aggregate project
  ).
  aggregate(firstSubProject, secondSubProject)

lazy val firstSubProject = (project in file("first-sub-project")).
	settings(
    name           			:= "first-sub-project",
    libraryDependencies += scalaTest % Test
  )

lazy val secondSubProject = (project in file("second-sub-project")).
	settings(
    name           			:= "second-sub-project",
    libraryDependencies += scalaTest % Test
  )  