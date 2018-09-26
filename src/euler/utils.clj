(ns euler.utils)

(defn divides?
  [num div]
  (zero? (mod num div)))
