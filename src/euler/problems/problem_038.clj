(ns euler.problems.problem-038
  (:require [euler.utils :refer :all]))

(defn- pandigital-number?
  [digits]
  (and (= 9 (count digits))
       (apply distinct? digits)
       (every? (into #{} (range 1 10)) digits)))

(defn- pandigital-products
  [n]
  (loop [digits []
         [x & r] (iterate inc 1)]
    (cond (pandigital-number? digits)
          (compose-number digits)

          (and (seq digits) (not (apply distinct? digits)))
          nil

          (some #{0} digits)
          nil

          (< 9 (count digits))
          nil

          (and (= 9 (count digits)) (= 2 x))
          nil

          :else
          (recur (concat digits (decompose-number (* x n))) r))))

(defn solution-038
  []
  (apply max (keep pandigital-products (range 2 10000))))

