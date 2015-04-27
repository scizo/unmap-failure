(ns unmap-failure.core
  (:require [unmap-failure.has-long])
  (:gen-class))

(defn -main
  [& args]
  (prn @(get (ns-publics (find-ns 'unmap-failure.has-long)) 'Long (delay :long-not-there))))
