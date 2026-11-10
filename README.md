# playground to demonstrate various lsp bugs

## navigate to source of macro when using :defined-by

`lsp/other.clj` defines a macro `bind-lots` that defines a dynamic var, and two
functions that use that var. 

`lsp/core.clj` calls `o/bind-lots` to create those vars, and uses one of them. Without
the `clj-kondo` hook, clojure-lsp will raise warnings about undefined var, and with the
hook but not `:defined-by` and `:exclude-when-defined-by`, clojure-lsp will warn about
unused public vars. with all, there are no warnings (as expected):

```
$ clojure-lsp diagnostics
[ 99%] Project analyzed            Finding diagnostics...
No diagnostics found!
```

here's the problem:

in `lsp/core.clj`, you can see signatures and docs of each of the vars as defined by the
hook. however, placing the cursor over line 4, `(o/bind-lots)`, and using lsp's "go to
definition" leads to itself, and using lsp's "show documentation" shows `*foo*` instead
of the originating macro.

i'd like to continue to see the macro's signature and "go to definition" when hovered
over the call.
