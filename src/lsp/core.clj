(ns lsp.core
  (:require [lsp.other :as o]))

(o/bind-lots)

(get *foo* :hello)

(get-foo)

(query-foo 1)
