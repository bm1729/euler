(ns euler.problems.problem-036
  (:require [euler.utils :refer :all]))

(defn- palindromic?
  [base n]
  (let [digits (decompose-number base n)]
    (= digits (reverse digits))))

(defn solution-036
  []
  (->> (range 1000000)
       (filter (partial palindromic? 10))
       (filter (partial palindromic? 2))
       (reduce +)))