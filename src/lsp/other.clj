(ns lsp.other)

(defmacro bind-lots []
  '[(def ^:dynamic *foo* nil)
    (defn get-foo [] *foo*)
    (defn query-foo [x] (get *foo* x))])
