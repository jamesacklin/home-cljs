(ns demo.views
  (:require [demo.routes :as routes]
            [demo.subs :as subs]
            [stylefy.core :as s]
            [re-frame.core :as re-frame]))

(def inline-li {:display "inline"
                :margin-left "0.5ch"})

(def colophon-li {:font-size "100%"
                  :line-height "1.3"
                  :margin-bottom "1em"})

(defn page-view [{:keys [header content]}]
  [:div
   [:main content]])

(defn about []
  [page-view
   {:content
    [:div
     [:h1 "About"]
     [:p "This is about it."]]}])

(defn home []
  [page-view
   {:content
    [:div
     [:h1 (s/use-style {:font-size "19vw"}) "James Acklin, "
      [:span (s/use-style {:font-size "63%"
                           :white-space "nowrap"}) 
       [:em "Designer "] "&" [:em " Developer"]]]
     [:h2 (s/use-style {:font-size "3em"}) "Index"]
     [:p "I’m James Acklin, a digital product designer and front-end web developer focused on usability, prototyping, and distributed design systems."]
     [:p "I work full-time for Nielsen" [:sup "*"] " in Pittsburgh, PA. I’ve created digital experiences and tools on the Web for startups, large agencies, and Fortune 500 companies" [:sup "†"] " for about a decade."]
     [:p "My design practice concentrates on human-centered design methodologies and high-fidelity prototyping with an emphasis on in-browser deliverables. I have a passion for manipulating data and working with the raw material of the web." [:sup "‡"]]
     [:p "Occasionally I conduct branding exercises, help software companies and websites with interaction design problems, and do general graphic design work on the side. Email me if you’d like to work on a project together."]
     [:div {:id "colophon"}
      [:ul
       [:li (s/use-style (merge colophon-li {::s/mode {:before {:content "'*'"}}}))
        "At Nielsen, I research, prototype, design, and contribute production interface code for all user-facing features of Rhiza, a web-based data visualization tool (formerly a ~30-person startup spun out of MAYA Design, acquired in 2017) specializing in geospatial analysis and user-programmable workflows. I also administer the Rhiza Design System, a standardized front-end component library designed for re-use by application developers within our division and beyond."]
       [:li (s/use-style (merge colophon-li {::s/mode {:before {:content "'†'"}}}))
        "I have worked with consumer packaged goods brands (the family of Nestlé ice cream brands, Del Monte foods, CLIF, Premier Protein), academic institutions and non-profits (The Winchester Thurston School, The Sarah Heinz House, The String Orchestra of Brooklyn), software vendors (VIA Oncology, Management Science Associates), retailers (Avalon Exchange, rue21, JOAN Boutique), restaurants (Primanti Brothers, Big Burrito), industrial and B2B concerns (HEICO Fasteners, HarbisonWalker International), and am beginning to branch out into the outdoor category (Aspire Racing/Jeremy Powers, the JAM Fund, and Dirt Rag Magazine)."]
       [:li (s/use-style (merge colophon-li {::s/mode {:before {:content "'‡'"}}}))
        "This site is written in ClojureScript using reagent, re-frame and stylefy, compiled with shadow-cljs, and served via ▴Now. Its source is availble on GitHub. The type and background treatments are inspired by the cover art for the 2017 Ben Frost album " [:em "The Centre Cannot Hold"] ". The choice of Times New Roman is 100% intentional."]]]]}])

(defn app-view [{:keys [page-id]}]
  (case page-id
    :home  [home]
    :about [about]))

(defn app-root []
  (app-view @(re-frame/subscribe [::subs/app-view])))