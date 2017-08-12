# Single project with sbt-release

A very simple Scala project that has one class and one test. The project
can be release with a single sbt command: `sbt "release with-defaults".

This command is provided by the [sbt-release plugin](https://github.com/sbt/sbt-release).

The resolver to publish to is defined as the target directory, this way, no credentials
or actual publishing is performed.