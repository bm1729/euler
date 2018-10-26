(ns euler.problems.problem-028
  (:require [euler.utils :refer :all]))

(defn- sum-corner-numbers
  [n]
  (+ (* 4 (square n))
     (* -6 n)
     6))

(defn solution-028
  []
  (->> (range 3 1002 2)                                     ;; Dimensions of squares
       (map sum-corner-numbers)
       (reduce +)
       inc))                                                ;; Add one for the centre