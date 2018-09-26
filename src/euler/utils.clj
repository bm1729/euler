(ns euler.utils)

(defn divides?
  [num div]
  (zero? (mod num div)))

(defn power
  [x n]
  (reduce * (repeat n x)))