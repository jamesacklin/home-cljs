(ns demo.views
  (:require [demo.routes :as routes]
            [demo.subs :as subs]
            [stylefy.core :as s]
            [re-frame.core :as re-frame]))

(def globals
  (let [sans  "IBM Plex Sans"
        serif "Times New Roman"
        bg    "white"
        fg    "blue"]
    {:bg          bg
     :fg          fg
     :font-base   (str "400 normal 2.5rem/2.75rem \"" serif "\"")
     :font-accent (str "400 normal 100% \"" sans "\"")
     :gradient-bg (str "linear-gradient(to right, " bg " 50%, " fg " 50%)")
     :gradient-fg (str "linear-gradient(to right, " fg " 50%, " bg " 50%)")}))

(def page-styles
    {:color      (globals :fg)
     :background (globals :gradient-bg)
     :font       (globals :font-base)})

(def type-styles 
  {:font                   (globals :font-base)
   :letter-spacing         "-0.03em"
   :word-spacing           "-0.05em"
   :text-rendering         "optimizeLegibility"
   :-webkit-font-smoothing "subpixel-antialiased"
   :font-kerning           "normal"})

(def headline-styles 
  {:font           (globals :font-base)
   :font-size      "19vw"
   :letter-spacing "-0.0625em"
   :line-height    "1"
   :margin         "0"
   :padding        "0"})

(def container-styles
  {:background              (globals :gradient-fg)
   :background-clip         "text"
   :-webkit-background-clip "text"
   :color                   "transparent"
   :padding                 "0 2.5vw"})

(defn page-view [{:keys [header content]}]
  [:div (s/use-style page-styles)
   [:main (s/use-style container-styles) content]])

(defn about []
  [page-view
   {:content
    [:div
     [:h1 (s/use-style headline-styles) "About"]
     [:p (s/use-style type-styles) "This is about it."]]}])

(defn home []
  [page-view
   {:content
    [:div
     [:h1 (s/use-style headline-styles) "Example Project"]
     [:p (s/use-style type-styles) [:a {:href (routes/about)} "Learn More"]]]}])

(defn app-view [{:keys [page-id]}]
  (case page-id
    :home  [home]
    :about [about]))

(defn app-root []
  (app-view @(re-frame/subscribe [::subs/app-view])))