repro:

```
noah ~/personal/lsp-example
jj:[@ vktvxuym 55e1665d]
$ rm -rf .clj-kondo/.cache .lsp/.cache                                                                              130
noah ~/personal/lsp-example
jj:[@ vktvxuym 55e1665d]
$ clojure-lsp diagnostics
[ 99%] Project analyzed            Finding diagnostics...
src/lsp/core.clj:9:10: error: [invalid-arity] lsp.other/one-arg is called with 2 args but expects 1
src/lsp/core.clj:5:4: info: [clojure-lsp/unused-public-var] Unused public var 'lsp.core/f'
src/lsp/core.clj:7:12: info: [clojure-lsp/unused-public-var] Unused public var 'lsp.core/R'
noah ~/personal/lsp-example
jj:[@ vktvxuym 55e1665d]
$ nvim src/lsp/core.clj
noah ~/personal/lsp-example
jj:[@ vktvxuym 55e1665d]
$ clojure-lsp diagnostics
[ 99%] Project analyzed            Finding diagnostics...
src/lsp/core.clj:5:4: info: [clojure-lsp/unused-public-var] Unused public var 'lsp.core/f'
src/lsp/core.clj:7:12: info: [clojure-lsp/unused-public-var] Unused public var 'lsp.core/R'
```
