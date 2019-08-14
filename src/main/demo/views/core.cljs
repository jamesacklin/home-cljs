(ns demo.views.core
  (:require [re-frame.core :as r]
            ; [stylefy.core :as s]
            ; [markdown-to-hiccup.core :as m]
            ; [demo.routes.core :as routes]
            [demo.subs.core :as subs]
            ; [demo.events.core :as evt]
            [demo.views.page :refer [page-view]]
            [demo.views.home :refer [home]]
            [demo.views.work :refer [work]]
            [demo.views.about :refer [about]]))

(defn app-view [{:keys [page-id]}]
  (case page-id
    :home  [home]
    :work  [work]
    :about [about]))

(defn app-root []
  (app-view @(r/subscribe [::subs/app-view])))