(ns euler.problems.problem-012
  (:require [euler.utils :refer :all]
            [clojure.math.numeric-tower :as math]))

(defn- factors-count
  [n]
  (let [[s _r] (math/exact-integer-sqrt n)]
    (->> (range 1 (inc s))
         (filter (partial divides? n))
         (mapcat (fn [x] [x (/ n x)]))
         distinct
         count)))

(defn- triangle-factors-count
  [n]
  (let [[a b] (if (even? n) [(/ n 2) (inc n)] [(/ (inc n) 2) n])]
    (* (factors-count a) (factors-count b))))

(defn solution-012
  []
  (loop [n 1]
    (let [num-factors (triangle-factors-count n)]
      (if (< 500 num-factors)
        (/ (* n (inc n)) 2)
        (recur (inc n))))))




