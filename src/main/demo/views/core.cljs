(ns demo.views.core
  (:require [re-frame.core :as r]
            [stylefy.core :as s]
            [markdown-to-hiccup.core :as m]
            [demo.routes :as routes]
            [demo.subs :as subs]
            [demo.events :as evt]
            [demo.views.page :refer [page-view]]
            [demo.views.home :refer [home]]
            [demo.views.about :refer [about]]))

(defn app-view [{:keys [page-id]}]
  (case page-id
    :home  [home]
    :about [about]))

(defn app-root []
  (app-view @(r/subscribe [::subs/app-view])))