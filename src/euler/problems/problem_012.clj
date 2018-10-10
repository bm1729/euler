(ns euler.problems.problem-012
  (:require [euler.utils :refer :all]))

(defn- number-of-divisors
  [n]
  (->> (range 1 n)
       (filter (partial divides? n))
       count))

(defn- triangular-numbers
  ([]
   (triangular-numbers 1 0))
  ([a b]
   (lazy-seq (cons (+ a b) (triangular-numbers (inc a) (+ a b))))))

(defn solution-012
  []
  (println (realized? (->> (triangular-numbers)
                           (filter #(> (number-of-divisors %) 4))
                           first)))
  (->> (triangular-numbers)
       (filter #(> (number-of-divisors %) 4))
       first))
