(ns demo.views.page
  (:require [re-frame.core :as r]
            [stylefy.core :as s] 
            [demo.subs :as subs]))

(defn twirly []
  (if @(r/subscribe [::subs/twirly])
    [:div (s/use-style {:position "fixed"})
     "🌐"]))

(defn page-view [{:keys [header content]}]
  [:div
   [twirly]
   [:main content]])