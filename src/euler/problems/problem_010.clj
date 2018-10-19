(ns euler.problems.problem-010
  (:require [euler.utils :refer :all]))

(defn- sieve-of-eratosthenes
  [n]
  (let [n+1 (inc n)
        n-over-2 (/ n 2)]
    (persistent!
      (reduce
        (fn [sieve num]
          (if (sieve num)
            (reduce disj! sieve (range (* 2 num) n+1 num))
            sieve))
        (transient (set (cons 2 (range 3 n+1 2))))
        (range 3 n-over-2)))))

(defn solution-010
  []
  (reduce + (sieve-of-eratosthenes 2000000)))
