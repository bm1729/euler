(ns euler.problems.problem-012
  (:require [euler.utils :refer :all]))

(defn- triangular-number-factors-count
  [n]
  (let [[a b] (if (even? n)
                [(/ n 2) (inc n)]
                [(/ (inc n) 2) n])]
    (* (count (factors a)) (count (factors b)))))

(defn- triangular-number
  [n]
  (/ (* n (inc n)) 2))

(defn solution-012
  []
  (some #(when (< 500 (triangular-number-factors-count %))
           (triangular-number %))
        (iterate inc 1)))




