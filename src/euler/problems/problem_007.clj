(ns euler.problems.problem-007
  (:require [euler.utils :refer :all]))

(defn solution-007
  []
  (nth (primes 200000) (dec 10001)))
