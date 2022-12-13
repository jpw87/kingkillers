(ns kingkillers.core
    (:require
     [reagent.core :as r]
     [reagent.dom :as d]
     [shadow.resource :as rc]
     [kingkillers.parser :as p]))

;; -------------------------
;; State
(def tmb-json-data (r/atom ""))
(def demo-blob-data (rc/inline "demo-tmb-blob-small.json"))

;; -------------------------
;; Views

(defn text-area-input [value]
  [:textarea {:class "form-control resize-none" :rows 20 :value @value :on-change #(reset! value (-> % .-target .-value))}])

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
     [text-area-input tmb-json-data]]
    [:div {:class "btn-toolbar"}
     [:input {:class "btn btn-primary" :type "button" :value "Submit" :on-click #(reset! tmb-json-data (p/parse @tmb-json-data))}]
     [:input {:class "btn btn-primary" :type "button" :value "Clear" :on-click #(reset! tmb-json-data "")}]
     [:input {:class "btn btn-primary" :type "button" :value "Demo Data" :on-click #(reset! tmb-json-data demo-blob-data)}]]]
   [:div {:class "text-center p-3"}
    [:br] [:br] [:br] ; TODO bottom align the copyright footer somehow
    [:footer [:p {:class "lead"} "© 2023 Copyright: Joshua White"]]]]
)

;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
