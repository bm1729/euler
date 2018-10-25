(ns euler.problems.problem-002
  (:require [euler.utils :refer :all]))

(defn solution-002
  []
  (->> (fibonacci-sequence)
       (take-while #(< % 4000000))
       (filter even?)
       (reduce +)))
