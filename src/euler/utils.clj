(ns euler.utils)

(defn divides?
  [num div]
  (zero? (mod num div)))

(defn power
  [x n]
  (reduce * (repeat n x)))

(defn square
  [n]
  (* n n))

(defn factorial
  [n]
  (reduce * (range 1N (inc n))))