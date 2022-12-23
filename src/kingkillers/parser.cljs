(ns kingkillers.parser
  (:require [kingkillers.parser.tmb :as tmb-parser]))

(defn parse [json]
  (for [raider (tmb-parser/parse-json json)]
    (str (tmb-parser/get-raider-str raider) " ")))