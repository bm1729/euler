(ns euler.problems.problem-026
  (:require [euler.utils :refer :all]))

(defn reciprocal-cycle-length
  [d]
  (loop [n 10
         remainders-set #{}
         remainders-list ()]
    (let [remainder (rem n d)]
      (cond (zero? remainder) 0
            (remainders-set remainder) (.indexOf remainders-list remainder)
            :else (recur (* 10 remainder) (conj remainders-set remainder) (conj remainders-list remainder))))))

(defn solution-026
  []
  (max-by reciprocal-cycle-length (range 2 1000)))