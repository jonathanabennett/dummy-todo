(ns todo.core
  (:require [todo.config :as config]
            [todo.components.example-component :as example-component]
            [com.stuartsierra.component :as component]
            [todo.components.pedestal-component :as pedestal-component]))

(defn todo-system
  [config]
  (component/system-map
   :example-component (example-component/new-example-component config)
   :pedestal-component (component/using
                        (pedestal-component/new-pedestal-component config)
                        [:example-component])))

(defn -main
  []
  (let [system (-> (config/read-config)
                   (todo-system)
                   (component/start-system))]
    (println "Starting practice TODO app with config")
    (.addShutdownHook
     (Runtime/getRuntime)
     (new Thread #(component/stop-system system)))))
