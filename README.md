# Multi project with sbt-release

A simple multi-project sbt project. Each project has one class and one test. 


## Releasing
The project can be release with a single sbt command: `sbt "release with-defaults".

This command is provided by the [sbt-release plugin](https://github.com/sbt/sbt-release).

The resolver to publish to is defined as the target directory, this way, no credentials
or actual publishing is performed.

### Artifacts
In a multi-project setup with aggregation (like this one), a command issued to the root
project, like `sbt compile`, will be forwarded to all of sub-projects.

This includes the root project and that means that `compile` will be triggered for:

* root
* firstSubProject
* secondSubProject

```
[info] Loading project definition from /Users/davidfrancoeur/workspace/sbt-learnings/project
[info] Set current project to my-multi-project-root (in build file:/Users/davidfrancoeur/workspace/sbt-learnings/)
> compile
[info] Updating {file:/Users/davidfrancoeur/workspace/sbt-learnings/}secondSubProject...
[info] Updating {file:/Users/davidfrancoeur/workspace/sbt-learnings/}root...
[info] Updating {file:/Users/davidfrancoeur/workspace/sbt-learnings/}firstSubProject...
[info] Resolving jline#jline;2.14.1 ...
[info] Done updating.
[info] Compiling 1 Scala source to /Users/davidfrancoeur/workspace/sbt-learnings/second-sub-project/target/scala-2.12/classes...
[info] Resolving jline#jline;2.14.1 ...
[info] Done updating.
[info] Compiling 1 Scala source to /Users/davidfrancoeur/workspace/sbt-learnings/first-sub-project/target/scala-2.12/classes...
[info] Resolving jline#jline;2.14.1 ...
[info] Done updating.
[success] Total time: 16 s, completed 11-Aug-2017 10:18:10 PM
```

To avoid publishing our root project when we issue the release command shown above,
(because it's an aggregate of the other two projects) we can use the following setting 
expressiont: `publish := {}`.