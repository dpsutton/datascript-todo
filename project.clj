(defproject datascript-todo "0.1.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.520"]
                 [datascript "0.18.3"]
                 [datascript-transit "0.3.0"]
                 [rum "0.4.0"]]

  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-figwheel "0.5.18"]]

  :cljsbuild {:builds [{:id           "advanced"
                        :source-paths ["src"]
                        :compiler     {:main          datascript-todo.core
                                       :output-to     "resources/public/todo.js"
                                       :output-dir    "resources/public/js"
                                       :optimizations :advanced
                                       :pretty-print  false}}]}

  :profiles {:dev {:cljsbuild    {:builds [{:id               "none"
                                            :figwheel {:on-jsload "datascript-todo.core/render"}
                                            :source-paths     ["src"]
                                            :compiler         {:main          datascript-todo.core
                                                               :asset-path    "js/none"
                                                               :output-to     "resources/public/js/todo.js"
                                                               :output-dir    "resources/public/js/none"
                                                               :optimizations :none
                                                               :source-map    true}}]}
                   :figwheel {:nrepl-middleware ["cider.nrepl/cider-middleware"]}
                   :dependencies [[figwheel-sidecar "0.5.18"]
                                  [cider/cider-nrepl "0.22.0-beta1"]]}})
