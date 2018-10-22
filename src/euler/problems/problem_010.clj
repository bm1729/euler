(ns euler.problems.problem-010
  (:require [euler.utils :refer :all]
            [clojure.math.numeric-tower :as math]))

(defn- sieve-of-eratosthenes
  [n]
  (let [n+1 (inc n)
        [sqrt-n _r] (math/exact-integer-sqrt n+1)]
    (persistent!
      (reduce
        (fn [sieve num]
          (if (sieve num)
            (reduce disj! sieve (range (* 2 num) n+1 num))
            sieve))
        (transient (set (cons 2 (range 3 n+1 2))))
        (range 3 sqrt-n)))))

(defn solution-010
  []
  (reduce + (sieve-of-eratosthenes 2000000)))
