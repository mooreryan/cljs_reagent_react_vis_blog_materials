(ns cljs_reagent_proj.core
  (:require
   [reagent.core :as r]
   [cljsjs.react-vis :as rvis]))

(def chart-data [{:x 1 :y 1}
                 {:x 2 :y 2}
                 {:x 3 :y 4}
                 {:x 4 :y 5}
                 {:x 5 :y 4}
                 {:x 6 :y 6}
                 {:x 7 :y 8}
                 {:x 8 :y 6}
                 {:x 9 :y 5}
                 {:x 10 :y 5}])

(def axis-style {:line {:stroke "#333"
                        :strokeLinecap "square"}
                 :ticks {:stroke "#999"}
                 :text {:stroke "none"
                        :fill "#333"}})

(defn line-chart [data]
  [:> rvis/XYPlot
   {:width 800
    :height 225
    :margin {:left 50 :right 50}}
   [:> rvis/XAxis
    {:tickTotal 10
     :tickSizeInner 0
     :tickSizeOuter 3
     :style axis-style}]
   [:> rvis/YAxis
    {:tickSizeInner 0
     :tickSizeOuter 3
     :style axis-style}]
   [:> rvis/LineSeries
    {:data data
     :color "#e47320"
     :strokeWidth 5
     :style {:fill "none"
             :strokeLinejoin "round"
             :strokeLinecap "round"}}]])

(defn app-scaffold []
  [:div
   [line-chart chart-data]])

(defn render-app []
  (r/render [app-scaffold]
            (.getElementById js/document "app")))

(render-app)
