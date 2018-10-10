(ns euler.problems.problem-010
  (:require [euler.utils :refer :all]))

(defn sieve-of-eratosthenes
  [n]
  (let [n+1 (inc n)]
    (loop [s (transient (set (cons 2 (range 3 n+1 2))))
           c 3]
      (cond
        (> c n) (persistent! s)
        (s c) (recur (reduce disj! s (range (square c) n+1 c)) (inc c))
        :else (recur s (inc c))))))

(defn solution-010
  []
  (reduce + (sieve-of-eratosthenes 2000000)))