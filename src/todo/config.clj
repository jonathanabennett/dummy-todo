(ns todo.config
  (:require
   [areo.core :as areo]
   [clojure.java.io :as io]))

(defn reqd-config
  []
  (-> "config.edn"
      (io/resource)
      (aero/read-config)))
