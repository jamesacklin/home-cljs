(ns demo.views.page
  (:require [re-frame.core :as r]
            [stylefy.core :as s] 
            [demo.routes.core :as routes]
            [demo.subs.core :as subs]))

(defn twirly []
  (if @(r/subscribe [::subs/twirly])
    [:div (s/use-style {:position "fixed"})
     "🌐"]))

(defn page-view [{:keys [header content]}]
  [:div
   [twirly]
   [:nav
    [:ol 
     [:li [:a {:href (routes/home)} "Index"]]
     [:li [:a {:href (routes/work)} "Work"]]]]
   [:main content]])