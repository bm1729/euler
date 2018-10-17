(ns euler.problems.problem-021
  (:require [euler.utils :refer :all]))

(defn- sum-factors
  [n]
  (- (reduce + (factors n)) n))

(defn solution-021
  []
  (->> (range 2 10000)
       (filter (fn [n]
                 (let [sum (sum-factors n)]
                   (and (not= sum n)
                        (= n (sum-factors sum))))))
       (reduce +)))
