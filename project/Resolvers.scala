import sbt._

object Resolvers {
	lazy val DummyResolver = Resolver.file("Unused transient repository", file("target/unusedrepo"))
}
