(ns euler.problems.problem-029
  (:require [euler.utils :refer :all]))

(defn solution-029
  []
  (count
    (into #{}
          (for [a (range 2 101)
                b (range 2 101)]
            (power a b)))))
