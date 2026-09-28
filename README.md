clone the repo then run the below

```
$ cat src/lsp/core.clj
(ns lsp.core
  (:require [lsp.other :as o]))

(defprotocol P
  (f [a]))

;; uncomment the line below to see that both usages are linted when linting a directory vs a file
;; (o/one-arg 1 2)

(defrecord R []
  P
  (f [_] (o/one-arg 1 2)))

$ clj-kondo --version
clj-kondo v2026.08.04

$ rm -rf .clj-kondo/.cache

$ clj-kondo --lint src
src/lsp/core.clj:9:10: error: lsp.other/one-arg is called with 2 args but expects 1
linting took 23ms, errors: 1, warnings: 0

$ clj-kondo --lint src/lsp/core.clj
linting took 9ms, errors: 0, warnings: 0
```

then edit `src/lsp/core.clj` to remove the comment on line 8:

```
$ cat src/lsp/core.clj
(ns lsp.core
  (:require [lsp.other :as o]))

(defprotocol P
  (f [a]))

;; uncomment the line below to see that both usages are linted when linting a directory vs a file
(o/one-arg 1 2)

(defrecord R []
  P
  (f [_] (o/one-arg 1 2)))

$ rm -rf .clj-kondo/.cache

$ clj-kondo --lint src
src/lsp/core.clj:8:1: error: lsp.other/one-arg is called with 2 args but expects 1
src/lsp/core.clj:12:10: error: lsp.other/one-arg is called with 2 args but expects 1
linting took 14ms, errors: 2, warnings: 0

$ clj-kondo --lint src/lsp/core.clj
src/lsp/core.clj:8:1: error: lsp.other/one-arg is called with 2 args but expects 1
src/lsp/core.clj:12:10: error: lsp.other/one-arg is called with 2 args but expects 1
linting took 6ms, errors: 2, warnings: 0
```
