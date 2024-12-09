(ns todo.components.example-component
  (:require [com.stuartsierra.component :as component]))

(defrecord ExampleComponent
           [config]
  component/Lifecycle

  (start [component]
    (println "Starting Example Component")
    (assoc component :state ::started))

  (stop [component]
    (println ";; Stopping Example Component")
    (assoc component :state nil)))

(defn new-example-component
  [config]
  (map->ExampleComponent {:config config}))
