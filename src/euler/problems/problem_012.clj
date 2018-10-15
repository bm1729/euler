(ns euler.problems.problem-012
  (:require [euler.utils :refer :all]
            [clojure.math.numeric-tower :as math]))

(defn- factors-count
  [n]
  (let [[s _r] (math/exact-integer-sqrt n)]
    (->> (range 1 (inc s))
         (filter (partial divides? n))
         (mapcat (fn [x]
                   (if (= n (* x x))
                     [x]
                     [x (/ n x)])))
         count)))

(defn- triangular-number-factors-count
  [n]
  (let [[a b] (if (even? n)
                [(/ n 2) (inc n)]
                [(/ (inc n) 2) n])]
    (* (factors-count a) (factors-count b))))

(defn- triangular-number
  [n]
  (/ (* n (inc n)) 2))

(defn solution-012
  []
  (some #(when (< 500 (triangular-number-factors-count %))
           (triangular-number %))
        (iterate inc 1)))




