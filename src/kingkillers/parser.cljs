(ns kingkillers.parser)

(deftype raider [name id attendance-points])

(defn get-attendance-points [raid-count attendance-percentage]
  (* (* raid-count 4) attendance-percentage))

(defn parse-json [json] 
  (for [r (.parse js/JSON json)]
    (->raider (.-name r) (.-id r) (get-attendance-points ^js/Number (.-raid_count r) ^js/Number (.-attendance_percentage r)))))

(defn parse [json]
  (for [raider (parse-json json)]
    (str
     (.-name raider) " "
     (.-id raider) " "
     ^js/Number (.-attendance-points raider) " ")))
