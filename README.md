# Possible Bug in Janino

Starting with 3.0.7 (I suspect with [this
commit](https://github.com/janino-compiler/janino/commit/63fe4d0542bc0bcd90f352ffd515be37e0a98e2b)
), Janino appears unable to find some classes on the classpath.

This repro explores two almost identical cases:

* a simple script that imports `junit.framework.TestCase`.
* the exact same script, plus a class named `junit.framework.nested.Breaker` added to the classpath

The first script succeeds, while the second fails -- see [example output](https://github.com/Datomic/janino-repro-3/blob/master/siderail/example-output).

# Running the Repro

run `./run-repro` from a bash shell.

# Notes

* Package names matter -- when I have encountered the problem, there is a class whose package name shares a prefix with the class to be imported.
* Classpath order matters -- if you move target/classes to the end of the classpath both runs succeed.
