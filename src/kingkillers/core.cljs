(ns kingkillers.core
    (:require
      [reagent.core :as r]
      [reagent.dom :as d]))

;; -------------------------
;; Views

(defn home-page [] 
  [:div {:class "container-fluid"}
    [:div {:class "jumbotron text-center"}
      [:h1 {:class "display-4"} "King Killers Point Calculation Tool"]
      [:p {:class "lead"} "<Regicide> King Killers Loot Council tool for determining priority points for items."]
      [:p {:class "lead"} "To use this tool, paste a \"Giant JSON blob\" from " [:a "https://thatsmybis.com"]]]
    [:form {:class "text-center"}
      [:div {:class "container form-group"}
        [:small {:class "form-text text-muted"} "Paste your \"That's my bis JSON Blob\" here"]
        [:br]
        [:textarea {:class "form-control resize-none" :rows 20}]]
      [:div {:class "btn-toolbar"}
        [:button {:class "btn btn-primary"} "Submit"]
        [:button {:class "btn btn-primary"} "Test"]]]
    [:div {:class "text-center p-3"}
      [:br][:br][:br] ; TODO bottom align the copyright footer somehow
      [:footer [:p {:class "lead"} "© 2023 Copyright: Joshua White"]]]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
