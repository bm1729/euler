(ns euler.problems.problem-035
  (:require [euler.utils :refer :all]))

(defn- candidates
  [n]
  (let [possible-digits #{1 3 7 9}]
    (reduce (fn [cands _]
              (mapcat (fn [pd] (map (fn [p] (conj pd p)) possible-digits)) cands))
            [[]]
            (range n))))

(defn- calculate-cycles
  [digits]
  (let [cycled-digits (cycle digits)
        digit-count (count digits)]
    (into #{} (map #(take digit-count (drop % cycled-digits)) (range digit-count)))))

(defn- all-cycles-prime?
  [primes digit-cycles]
  (every? (fn [digits]
            (contains? primes (compose-number digits))) digit-cycles))

(defn solution-035
  []
  (let [primes (into #{} (primes 1000000))]
    (+ 4 (->> (apply concat (map #(candidates %) (range 2 7)))
              (map calculate-cycles)
              (filter (partial all-cycles-prime? primes))
              count))))