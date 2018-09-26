(ns euler.utils)

(defn divides?
  [x y]
  (zero? (mod x y)))
