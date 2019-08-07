(ns demo.views.about
  (:require [re-frame.core :as r]
            [stylefy.core :as s]
            [demo.views.page :refer [page-view]]))

(defn about []
  [page-view
   {:content [:div
              [:h1 "About"]
              [:p "This is about it."]]}])