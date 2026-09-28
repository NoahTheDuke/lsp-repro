(ns lsp.core
  (:require [lsp.other :as o]))

(defprotocol P
  (f [a]))

;; uncomment the line below to see that both usages are linted when linting a directory vs a file
;; (o/one-arg 1 2)

(defrecord R []
  P
  (f [_] (o/one-arg 1 2)))
