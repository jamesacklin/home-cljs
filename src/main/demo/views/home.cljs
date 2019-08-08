(ns demo.views.home
  (:require [re-frame.core :as r]
            [stylefy.core :as s] 
            [demo.views.page :refer [page-view]]))

(def inline-li {:display     "inline"
                :margin-left "0.5ch"})

(def colophon-li {:font-size     "100%"
                  :line-height   "1.3"
                  :margin-bottom "1em"})

(defn title [] [:h1 (s/use-style {:font-size      "18.76vw"
                                  :letter-spacing "-0.075em"
                                  :line-height    "0.75"
                                  :margin-bottom  "0.5em"})
                [:span (s/use-style {:white-space "nowrap"
                                     :display     "block"}) "James Acklin, "]
                [:span (s/use-style {:font-size    "15.25vw"
                                     :display      "block"
                                     :word-spacing "0em"
                                     :white-space  "nowrap"})
                 "a "
                 [:em (s/use-style {:padding-left   "0.1em"
                                    :letter-spacing "-0.05em"}) "coding designer"]]])

(defn home []
  [page-view
   {:content
    [:div
     [title]
     [:p "I’m James Acklin, a "[:span {:title "I have not yet designed a chair"} "digital product designer"]" and front-end web developer focused on usability, prototyping, and distributed design systems."]
     [:p "I work full-time for " [:em "Nielsen Media Analytics"] [:sup "*"] " in Pittsburgh, PA. I’ve created digital experiences and tools on the Web for startups, large agencies, and Fortune 500 companies" [:sup "†"] " for about a decade."]
     [:p "My design practice concentrates on human-centered design methodologies and high-fidelity prototyping with an emphasis on in-browser deliverables. I have a passion for manipulating data and working with the raw material of the web." [:sup "‡"]]
     [:p "Occasionally I conduct branding exercises, help software companies and websites with interaction design problems, and do general graphic design work on the side. I am not currently accepting freelance engagements."]
     [:div {:id "colophon"}
      [:ul
       [:li (s/use-style (merge colophon-li {::s/mode {:before {:content "'*'"}}}))
        "At Nielsen, I research, prototype, design, and contribute production interface code for all user-facing features of Rhiza, a web-based data visualization tool used by Media Analytics to perform geospatial analysis and publish client-facing instruments. I also administer the Rhiza Design System, a standardized front-end component library designed for re-use by application developers within Media Analytics and beyond."]
       [:li (s/use-style (merge colophon-li {::s/mode {:before {:content "'†'"}}}))
        "I have worked with consumer packaged goods brands (the family of Nestlé ice cream brands, Del Monte foods, CLIF, Premier Protein), academic institutions and non-profits (The Winchester Thurston School, The Sarah Heinz House, The String Orchestra of Brooklyn), software vendors (VIA Oncology, Management Science Associates), retailers (Avalon Exchange, rue21, JOAN Boutique), restaurants (" [:a {:href "https://primantibros.com/"}"Primanti Brothers"] ", Big Burrito), industrial and B2B concerns (HEICO Fasteners, HarbisonWalker International), and cycling (Aspire Racing/Jeremy Powers, the JAM Fund, " [:a {:href "https://github.com/jamesacklin/send"} "Dirt Rag Magazine"] ", " [:a {:href "https://github.com/jamesacklin/ssc"} "Steady State Cycles"] ")."]
       [:li (s/use-style (merge colophon-li {::s/mode {:before {:content "'‡'"}}}))
        "This site is written in ClojureScript using Reagent, re-frame and stylefy, compiled with shadow-cljs, and served via ▴Now. " [:a {:href "https://github.com/jamesacklin/home-cljs"} "Its source is available on GitHub."] " The type and background treatments are inspired by the cover art for the 2017 Ben Frost album " [:em "The Centre Cannot Hold"] "."]]]]}])