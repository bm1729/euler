(ns euler.problems.problem-006
  (:require [euler.utils :refer :all]))

(defn solution-006
  []
  (let [sum-of-squares (reduce + (map #(power % 2) (range 1 101)))
        square-of-sums (power (reduce + (range 1 101)) 2)]
    (- square-of-sums sum-of-squares)))