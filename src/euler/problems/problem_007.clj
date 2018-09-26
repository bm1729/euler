(ns euler.problems.problem-007
  (:require [euler.utils :refer :all]))

(defn- prime?
  [num primes]
  (->> primes
       (filter #(<= (* % %) num))
       (filter (partial divides? num))
       empty?))

(defn- primes
  ([]
    (primes 3 [2]))
  ([candidate found]
   (cond (= (count found) 10001) found
         (prime? candidate found) (recur (+ 2 candidate) (conj found candidate))
         :else (recur (+ 2 candidate) found))))

(defn solution-007
  []
  (last (primes)))
