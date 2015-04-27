# unmap-failure

Minimal example showing a different order of execution when aot-compiled.

`lein run` prints `:long-exists` whereas
`lein uberjar && java -jar target/uberjar/unmap-failure-0.1.0-SNAPSHOT-standalone.jar`
prints `:long-not-there`, along with the warning
`WARNING: Long already refers to: class java.lang.Long in namespace: unmap-failure.has-long, being replaced by: #'unmap-failure.has-long/Long`

It appears that the aot-compilation causes the definition of the Long var before the ns-unmap occurs,
causing ns-unmap to unmap the desired Long not the reference to java.lang.Long.
