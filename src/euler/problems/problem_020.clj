(ns euler.problems.problem-020
  (:require [euler.utils :refer :all]))

(defn solution-020
  []
  (->> (factorial 100)
       str
       (map #(str %))
       (map #(Integer/parseInt %))
       (reduce +)))
