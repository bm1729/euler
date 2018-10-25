(ns euler.problems.problem-016
  (:require [euler.utils :refer :all]))

(defn solution-016
  []
  (reduce + (decompose-number (power 2 1000))))