(ns euler.utils
  (:require [clojure.math.numeric-tower :as math]))

(defn divides?
  [num div]
  (zero? (mod num div)))

(defn power
  [x n]
  (reduce * 1N (repeat n x)))

(defn square
  [n]
  (* n n))

(defn factorial
  [n]
  (reduce * (range 1N (inc n))))

(defn sum-digits
  [n]
  (->> n
       str
       (map #(str %))
       (map #(Integer/parseInt %))
       (reduce +)))

(defn factors
  "Returns list of unordered factors of n (including 1)"
  [n]
  (let [[s _r] (math/exact-integer-sqrt n)]
    (->> (range 1 (inc s))
         (filter (partial divides? n))
         (mapcat (fn [x]
                   (if (= n (* x x))
                     [x]
                     [x (/ n x)]))))))