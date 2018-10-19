(ns euler.problems.problem-023
  (:require [euler.utils :refer :all]))

(defn abundant?
  [n]
  (< (+ n n) (reduce + (factors n))))

(defn solution-023
  []
  (let [abundant-numbers (filter abundant? (range 1 28124))
        abundant-sums (into #{} (for [x abundant-numbers
                                      y abundant-numbers
                                      :when (>= x y)
                                      :when (> 28124 (+ x y))]
                                  (+ x y)))]
    (reduce + (clojure.set/difference (into #{} (range 1 28124)) abundant-sums))))
