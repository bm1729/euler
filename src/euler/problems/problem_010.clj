(ns euler.problems.problem-010
  (:require [euler.utils :refer :all]))

(defn solution-010
  []
  (reduce + (primes 2000000)))
