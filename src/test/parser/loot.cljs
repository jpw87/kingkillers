(ns test.parser.loot
  (:require [cljs.test :refer-macros [deftest is testing run-tests]]))

(deftest test-numbers
  (is (= 7334562 7334562)))