(ns kingkillers.parser.loot
  (:require [shadow.resource :as rc]))

;; -------------------------
;; State
;; Ideally these should be cached some day or something, not always loaded each time
(def naxx-loot (rc/inline "loot/NaxxramasLoot.json"))
(def eoe-loot (rc/inline "loot/EyeOfEternityLoot.json"))
(def os-loot (rc/inline "loot/ObsidianSanctumLoot.json"))