(ns euler.problems.problem-030
  (:require [euler.utils :refer :all]))

(defn- is-sum-of-digits-powered?
  [n]
  (= n (reduce + (map #(power % 5) (decompose-number n)))))

(defn solution-030
  "9^5 = 59049. Therefore the largest 6 digit number has powered digit sum of 35494. So set that as the max."
  []
  (->> (range 10 354294)
       (filter is-sum-of-digits-powered?)
       (reduce +)))