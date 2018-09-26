(ns euler.problems.problem-001
  (:require [euler.utils :refer :all]))

(defn solution-001
  []
  (->> (range 1000)
       (filter #(or (divides? % 3) (divides? % 5)))
       (reduce +)))
