(ns demo.views
  (:require [re-frame.core :as r]
            [stylefy.core :as s]
            [markdown-to-hiccup.core :as m]
            [demo.routes :as routes]
            [demo.subs :as subs]
            [demo.events :as evt]
            [demo.views.page :refer [page-view]]
            [demo.views.home :refer [home]]))

(defn about []
  [page-view
   {:content
    [:div
     [:h1 "About"]
     [:p "This is about it."]]}])

(defn app-view [{:keys [page-id]}]
  (case page-id
    :home  [home]
    :about [about]))

(defn app-root []
  (app-view @(r/subscribe [::subs/app-view])))