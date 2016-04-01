Demonstrates logging shutdown by Server created via Server.withRouter(). 
Edit [test/ServerTest.scala](test/ServerTest.scala), changing the first `it` to `ignore`, and notice the subsequent logs appear.

See also
[Server.scala](https://github.com/playframework/playframework/blob/440be28c9598d4ff0957cda1367803f95f4c50a0/framework/src/play-server/src/main/scala/play/core/server/Server.scala#L71-L75)


## Before

```
➜  play-2.5-logging-test sbt test
[info] Loading global plugins from /Users/jswhite/.sbt/0.13/plugins
[info] Loading project definition from /Users/jswhite/workspace-n/play-2.5-logging-test/project
[info] Set current project to play-2.5-logging-test (in build file:/Users/jswhite/workspace-n/play-2.5-logging-test/)
Warning: node.js detection failed, sbt will use the Rhino based Trireme JavaScript engine instead to run JavaScript assets compilation, which in some cases may be orders of magnitude slower than using node.js.
[info] ServerTest:
[info] WSTestClient
[error] ServerTest - log1
[info] - should work with Server.withRouter() and print log1
[info] - should print log2
[info] - should print log3
[info] ScalaTest
[info] Run completed in 2 seconds, 838 milliseconds.
[info] Total number of tests run: 3
[info] Suites: completed 1, aborted 0
[info] Tests: succeeded 3, failed 0, canceled 0, ignored 0, pending 0
[info] All tests passed.
[info] Passed: Total 3, Failed 0, Errors 0, Passed 3
[success] Total time: 4 s, completed Apr 1, 2016 9:08:39 AM
```

## After

```
➜  play-2.5-logging-test sbt test
[info] Loading global plugins from /Users/jswhite/.sbt/0.13/plugins
[info] Loading project definition from /Users/jswhite/workspace-n/play-2.5-logging-test/project
[info] Set current project to play-2.5-logging-test (in build file:/Users/jswhite/workspace-n/play-2.5-logging-test/)
Warning: node.js detection failed, sbt will use the Rhino based Trireme JavaScript engine instead to run JavaScript assets compilation, which in some cases may be orders of magnitude slower than using node.js.
[info] Compiling 1 Scala source to /Users/jswhite/workspace-n/play-2.5-logging-test/target/scala-2.11/test-classes...
[info] ServerTest:
[info] WSTestClient
[info] - should work with Server.withRouter() and print log1 !!! IGNORED !!!
[error] ServerTest - log2
[info] - should print log2
[info] - should print log3
[error] ServerTest - log3
[info] ScalaTest
[info] Run completed in 842 milliseconds.
[info] Total number of tests run: 2
[info] Suites: completed 1, aborted 0
[info] Tests: succeeded 2, failed 0, canceled 0, ignored 1, pending 0
[info] All tests passed.
[info] Passed: Total 2, Failed 0, Errors 0, Passed 2, Ignored 1
[success] Total time: 5 s, completed Apr 1, 2016 9:12:09 AM
```