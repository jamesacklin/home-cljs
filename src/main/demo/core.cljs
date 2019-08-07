(ns demo.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [day8.re-frame.http-fx]
            [breaking-point.core :as bp]
            [stylefy.core :as stylefy]
            [demo.events :as events]
            [demo.subs :as subs]
            [demo.views.core :as views]
            [demo.routes :as routes]))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/app-root]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [:initialize-db])
  (re-frame/dispatch-sync 
   [::bp/set-breakpoints {:breakpoints [:mobile 768
                                        :tablet 960
                                        :small-monitor 1200
                                        :large-monitor]
                          :debounce-ms 166}])
  (routes/app-routes re-frame/dispatch)
  (stylefy/init)
  (mount-root))