(ns euler.problems.problem-037
  (:require [euler.utils :refer :all]))

(defn- left-truncatable-prime?
  [prime-set candidate]
  (let [digits (decompose-number candidate)]
    (every? prime-set (map #(compose-number (drop % digits)) (range (count digits))))))

(defn- right-truncatable-prime?
  [prime-set candidate]
  (let [digits (decompose-number candidate)]
    (every? prime-set (map #(compose-number (take (inc %) digits)) (range (count digits))))))

(defn- truncatable-prime?
  [prime-set candidate]
  (and (left-truncatable-prime? prime-set candidate)
       (right-truncatable-prime? prime-set candidate)))

(defn solution-037
  []
  (let [ps (primes 1000000)
        prime-set (into #{} ps)]
    (loop [truncatable-primes []
           [c & r] (drop 4 ps)]
      (cond (= 11 (count truncatable-primes)) (reduce + truncatable-primes)
            (truncatable-prime? prime-set c) (recur (conj truncatable-primes c) r)
            :else (recur truncatable-primes r)))))