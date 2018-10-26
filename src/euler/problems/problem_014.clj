(ns euler.problems.problem-014
  (:require [euler.utils :refer :all]))

(defn- collatz-seq-length
  [n]
  (loop [x n
         c 1]
    (cond (= 1 x) c
          (even? x) (recur (/ x 2) (inc c))
          :else (recur (inc (* 3 x)) (inc c)))))

(defn solution-014
  []
  (max-by collatz-seq-length (range 500000 1000000)))
