(ns euler.problems.problem-020
  (:require [euler.utils :refer :all]))

(defn solution-020
  []
  (sum-of-digits (factorial 100)))
