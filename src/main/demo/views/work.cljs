(ns demo.views.work
  (:require [re-frame.core :as r]
            [stylefy.core :as s]
            [demo.subs.core :as subs]
            [demo.views.page :refer [page-view]]))

(defn big-work []
  (if (true? @(r/subscribe [::subs/work-expanded]))
    {:max-width "100%"
     :cursor "zoom-out"}
    {:max-width "55em"
     :cursor "zoom-in"}))

(defn work []
  [page-view
   {:content
    [:div
     [:h1 (s/use-style {:font-size "10vw"}) "Work"]
     [:p "For the past ~6 years, I have been the primary designer (and a contributing front-end developer) for Rhiza, a data research tool and analytics startup spun off from MAYA Design in 2007 and acquired by The Nielsen Company in 2017. I have led innovation in our user interface through primary research, concepting, prototyping, validation, detailed visual design, and front-end development."]
     [:p "In short, Rhiza is a B2B data visualization product used by many teams at Nielsen. It is designed to mask its own complexity in order to deliver simple, actionable results, while simultaneously providing great expressive power for data storytellers and researchers."]
     [:p "I have also worked on various early-stage product concepts and lent a UXer’s hand to product teams in need of usability enhancements or wrangling their visual design system."]
     [:p "I’d be happy to show you what my work for Nielsen looks like, but I’m still working on exactly how to communicate its constant user-centric evolution. Instead, here’s a folder listing of the single-player dungeon crawler that has been the past 6 years of my career. The folders are ordered by year, then month. Detailed timeline and case studies forthcoming."]
     [:div (s/use-style (merge (big-work)
                               {:transition "all 0.2s ease"})
                        {:on-click #(r/dispatch [:expand-work])})
      [:img {:src "/images/dungeon.png"}]]]}])
