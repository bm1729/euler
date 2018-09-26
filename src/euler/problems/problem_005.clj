(ns euler.problems.problem-005
  (:require [euler.utils :refer :all]))

(defn- prime-factors
  ([num]
   (prime-factors num 2))
  ([num candidate]
   (cond (= candidate num) [num]
         (divides? num candidate) (conj (prime-factors (/ num candidate) candidate) candidate)
         :else (prime-factors num (inc candidate)))))

(defn solution-005
  []
  (->> (range 2 21)
       (map prime-factors)
       (map frequencies)
       (apply merge-with max)
       (map (fn [[k v]] (power k v)))
       (reduce *)))