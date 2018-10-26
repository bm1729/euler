(ns euler.problems.problem-026
  (:require [euler.utils :refer :all]))

(defn reciprocal-cycle-length
  [d]
  (loop [n 10
         remainders []]
    (let [remainder (rem n d)]
      (cond (zero? remainder) 0
            (seq (filter #(= remainder %) remainders)) (inc (.indexOf (reverse remainders) remainder))
            :else (recur (* 10 remainder) (conj remainders remainder))))))

(defn solution-026
  []
  (max-by reciprocal-cycle-length (range 2 1000)))