(ns todo.config
  (:require
   [aero.core :as aero]
   [clojure.java.io :as io]))

(defn reqd-config
  []
  (-> "config.edn"
      (io/resource)
      (aero/read-config)))
