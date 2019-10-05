(ns cljs_reagent_proj.core
  (:require
    [reagent.core :as r]))

(defn say-hi []
  "Hi from core.cljs!")

;;;; HTML IDs

(def html-id-app "app")

;;;; Components

(defn app-scaffold []
  [:div
   [:p "I'm the app!"]])

;;;; Rendering

(defn render-app []
  (r/render [app-scaffold]
            (.getElementById js/document html-id-app)))

(render-app)
