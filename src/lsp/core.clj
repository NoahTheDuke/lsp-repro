(ns lsp.core
  (:require [lsp.other :as o]))

(defprotocol P
  (f [a]))

(defrecord R []
  P
  (f [_] (o/one-arg 1 2)))
