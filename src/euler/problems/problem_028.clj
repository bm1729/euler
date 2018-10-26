(ns euler.problems.problem-028
  (:require [euler.utils :refer :all]))

(defn- corner-numbers
  [n]
  (map #(- (square n) (* % (- n 1))) (range 0 4)))

(defn solution-028
  []
  (->> (range 3 1002 2)                                     ;; Dimensions of squares
       (mapcat corner-numbers)
       (reduce +)
       inc))                                                ;; Add one for the centre