(ns euler.problems.problem-027
  (:require [euler.utils :refer :all]))

(defn- quadratic
  [a b n]
  (+ (square n) (* a n) b))

(defn- quadratic-prime-length
  [[a b]]
  (count (take-while #(prime? (quadratic a b %)) (range))))

(defn solution-027
  []
  (let [[a-best b-best] (max-by quadratic-prime-length (for [a (range -999 1000)
                                                             b (primes 1000)]
                                                         [a b]))]
    (* a-best b-best)))
