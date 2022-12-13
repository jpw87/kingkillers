(ns kingkillers.parser
  (:require [shadow.resource :as rc]))

;; -------------------------
;; Define types we'll use in parsing
(deftype raider [name id attendance-points wishlist])
(deftype wishlist [[wishlist-items]])
(deftype wishlist-item [name item-id instance_id])

;; -------------------------
;; State
;; Ideally these should be cached some day or something, not always loaded each time
(def naxx-loot (rc/inline "loot/NaxxramasLoot.csv"))
(def eoe-loot (rc/inline "loot/EyeOfEternityLoot.csv"))
(def os-loot (rc/inline "loot/ObsidianSanctumLoot.csv"))

;; -------------------------
;; Business logic
(defn get-attendance-points [raid-count attendance-percentage]
  (* (* raid-count 4) attendance-percentage))

(defn get-wishlist-from-raider-json [raider-json]
  (for [item ^js/Array (.-wishlist raider-json)]
    (str (.-name item) " ")))

(defn parse-json [json]
  (for [r (.parse js/JSON json)]
    (->raider
     (.-name r)
     (.-id r)
     (get-attendance-points ^js/Number (.-raid_count r) ^js/Number (.-attendance_percentage r))
     (get-wishlist-from-raider-json r))))

(defn get-wishlist-str [wishlist]
  (for [w wishlist]
    (str w " ")))

(defn get-raider-str [raider]
  (str
   (.-name raider) " "
   (.-id raider) " "
   ^js/Number (.-attendance-points raider) " "
   (get-wishlist-str ^js/Array (.-wishlist raider))))

(defn parse [json]
  (for [raider (parse-json json)]
    (str (get-raider-str raider) " ")))