repro:

```
$ clj-kondo --version
clj-kondo v2026.08.04

$ rm -rf .clj-kondo/.cache

$ clj-kondo --lint src
src/lsp/core.clj:9:10: error: lsp.other/one-arg is called with 2 args but expects 1
linting took 23ms, errors: 1, warnings: 0

$ clj-kondo --lint src/lsp/core.clj
linting took 9ms, errors: 0, warnings: 0
```
